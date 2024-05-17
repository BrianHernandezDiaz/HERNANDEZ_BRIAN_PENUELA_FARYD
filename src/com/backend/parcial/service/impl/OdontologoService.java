package com.backend.parcial.service.impl;

import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.repository.IDao;
import com.backend.parcial.service.IOdontologoService;

import java.util.List;

public class OdontologoService implements IOdontologoService {

    //capa de logica de negocio que interactua con la capa de persistencia, pero desconoce los detalles de la implementacion de esa persistencia
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        //alguna logica de negocio

        return odontologoIDao.registrar(odontologo);
    }

    @Override
    public List<Odontologo> listarOdotonlogo() {
        return odontologoIDao.listarTodos();
    }

}
