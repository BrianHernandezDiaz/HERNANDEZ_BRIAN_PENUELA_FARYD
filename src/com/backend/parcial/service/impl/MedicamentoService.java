package com.backend.parcial.service.impl;

import com.backend.parcial.entity.Medicamento;
import com.backend.parcial.repository.IDao;
import com.backend.parcial.service.IMedicamentoService;

public class MedicamentoService implements IMedicamentoService {

    //capa de logica de negocio que interactua con la capa de persistencia, pero desconoce los detalles de la implementacion de esa persistencia
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    @Override
    public Medicamento registrarMedicamento(Medicamento medicamento) {
        //alguna logica de negocio

        return medicamentoIDao.registrar(medicamento);
    }

    @Override
    public Medicamento buscarMedicamentoPorId(Long id) {
        return medicamentoIDao.buscarPorId(id);
    }
}
