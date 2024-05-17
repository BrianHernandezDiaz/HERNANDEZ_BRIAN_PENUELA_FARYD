package com.backend.parcial.repository.impl;

import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.repository.IDao;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    List <Odontologo> listaOdontologos = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(OdontologoDaoEnMemoria.class);

    public OdontologoDaoEnMemoria() {
        Odontologo odontologo1 = new Odontologo(1L, 69, "Jaime","Perlas");
        Odontologo odontologo2 = new Odontologo(2L, 69, "Juancho","Tellez");
        listaOdontologos.add(odontologo1);
        listaOdontologos.add(odontologo2);
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Long id = Long.valueOf(listaOdontologos.size()+1);
        Odontologo odontologoARegistrar = new Odontologo(id, odontologo.getNumero_matricula(), odontologo.getNombre(), odontologo.getApellido());
        listaOdontologos.add(odontologoARegistrar);
        logger.info("se guardó el siguiente odontologo: " + odontologoARegistrar);
        return odontologoARegistrar;
    }

    @Override
    public List<Odontologo> listarTodos() {

        logger.info("se encontraron los siguentes odontologos: " + listaOdontologos);

        return listaOdontologos;
    }

}