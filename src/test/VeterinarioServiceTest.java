package test;

import dao.impl.VeterinarioDaoH2;
import model.Veterinario;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.VeterinarioService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioServiceTest {
    static  final Logger logger = Logger.getLogger(VeterinarioServiceTest.class);
    VeterinarioService veterinarioService = new VeterinarioService(new VeterinarioDaoH2());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./veterinaria;INIT=RUNSCRIPT FROM 'create.sql'",
                    "sa", "sa");

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    @Test
    @DisplayName("Testear que un veterinario se guardo en la bd")
    void caso1(){
        Veterinario veterinario = new Veterinario(3313131, "Maria",
                "Jimenez", "Oftalmologia");
        Veterinario veterinarioDesdeDB = veterinarioService.guardarVeterinario(veterinario);
        assertNotNull(veterinarioDesdeDB.getId());
    }

    @Test
    @DisplayName("Testear que traiga todos los veterinarios guardados")
    void caso2(){
        List<Veterinario> veterinarios = new ArrayList<>();
        veterinarios = veterinarioService.buscarTodos();
        assertTrue(veterinarios.size()!=0);
    }

}