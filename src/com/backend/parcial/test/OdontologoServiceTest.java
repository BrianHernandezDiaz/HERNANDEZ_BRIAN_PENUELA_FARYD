package com.backend.parcial.test;

import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.repository.impl.OdontologoDaoH2;
import com.backend.parcial.service.impl.OdontologoService;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OdontologoServiceTest {
    private OdontologoService odontologoService;


    @Test
    void deberiaInsertarUnOdontologoYRetornarElIdEnH2() {
        //arrange
        odontologoService = new OdontologoService(new OdontologoDaoH2());
        Odontologo odontologoAPersistir = new Odontologo("Aspirina", "Bayer", 50, 1500);

        //act
        Odontologo odontologoPersistido = odontologoService.registrarOdontologo(odontologoAPersistir);

        //assert
        assertEquals(odontologoPersistido.getId());
    }

}