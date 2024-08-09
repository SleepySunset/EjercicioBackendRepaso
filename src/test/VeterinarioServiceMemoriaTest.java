package test;

import dao.impl.VeterinarioDaoH2;
import dao.impl.VeterinarioDaoMemoria;
import model.Veterinario;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.VeterinarioService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioServiceMemoriaTest {
    static  final Logger logger = Logger.getLogger(VeterinarioServiceMemoriaTest.class);
    VeterinarioService veterinarioService = new VeterinarioService(new VeterinarioDaoMemoria());

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
        Veterinario veterinario1 = new Veterinario(3313131, "Laura",
                "Lopez", "Dermatologia");
        Veterinario veterinario2 = new Veterinario(3313131, "Maria",
                "Jimenez", "Oftalmologia");
        List<Veterinario> veterinarios = new ArrayList<>();
        veterinarioService.guardarVeterinario(veterinario1);
        veterinarioService.guardarVeterinario(veterinario2);
        veterinarios = veterinarioService.buscarTodos();
        assertTrue(veterinarios.size()!=0);
    }

}