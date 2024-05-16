package com.backend.parcial.repository.impl;

import com.backend.parcial.entity.Medicamento;
import com.backend.parcial.repository.IDao;

public class MedicamentoDaoEnMemoria implements IDao<Medicamento> {
    @Override
    public Medicamento registrar(Medicamento medicamento) {
        return null;
    }

    @Override
    public Medicamento buscarPorId(Long id) {
        return null;
    }
}