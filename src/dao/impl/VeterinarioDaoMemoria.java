package dao.impl;

import dao.IDao;
import model.Veterinario;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class VeterinarioDaoMemoria implements IDao<Veterinario> {
    public static final Logger logger = Logger.getLogger(VeterinarioDaoMemoria.class);
    private List<Veterinario> veterinarios = new ArrayList<>();

    @Override
    public Veterinario guardarVeterinario(Veterinario veterinario) {
        veterinario.setId(veterinarios.size()+1);
        veterinarios.add(veterinario);
        logger.info("veterinario guardado " + veterinario);
        return veterinario;
    }

    @Override
    public List<Veterinario> buscarTodos() {
        for(Veterinario veterinario: veterinarios){
            logger.info(veterinario);
        }
        return veterinarios;
    }
}
