package com.backend.parcial.repository.impl;

import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.repository.IDao;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    @Override
    public Odontologo registrar(Odontologo odontologo) {
        return null;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return null;
    }

}