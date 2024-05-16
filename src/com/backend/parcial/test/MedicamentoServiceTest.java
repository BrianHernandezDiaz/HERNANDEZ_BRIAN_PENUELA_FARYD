package com.backend.parcial.test;

import com.backend.parcial.entity.Medicamento;
import com.backend.parcial.repository.impl.MedicamentoDaoH2;
import com.backend.parcial.service.impl.MedicamentoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MedicamentoServiceTest {
    private MedicamentoService medicamentoService;


    @Test
    void deberiaInsertarUnMedicamentoYRetornarElIdEnH2() {
        //arrange
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        Medicamento medicamentoAPersistir = new Medicamento(2558, "Aspirina", "Bayer", 50, 1500);

        //act
        Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamentoAPersistir);

        //assert
        assertNotNull(medicamentoPersistido.getId());

    }

}