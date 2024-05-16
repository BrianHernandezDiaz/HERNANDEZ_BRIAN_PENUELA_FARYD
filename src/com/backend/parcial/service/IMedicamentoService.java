package com.backend.parcial.service;

import com.backend.parcial.entity.Medicamento;

public interface IMedicamentoService {
    Medicamento registrarMedicamento(Medicamento medicamento);
    Medicamento buscarMedicamentoPorId(Long id);
}
