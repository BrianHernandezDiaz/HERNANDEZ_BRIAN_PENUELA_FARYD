package com.backend.parcial.repository.impl;

import com.backend.parcial.entity.Medicamento;
import com.backend.parcial.repository.IDao;
import com.backend.parcial.repository.dbconnection.H2Connection;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);


    @Override
    public Medicamento registrar(Medicamento medicamento) {
        String insert = "INSERT INTO MEDICAMENTOS(CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO) VALUES(?, ?, ?, ?, ?)";

        Connection connection = null;
        Medicamento medicamentoRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, medicamento.getCodigo());
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getPrecio());
            preparedStatement.execute();

            //connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                medicamentoRegistrado = new Medicamento(resultSet.getLong("id"), medicamento.getCodigo(), medicamento.getNombre(), medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
            }
            connection.commit();
            LOGGER.info("Medicamento guardado: " + medicamentoRegistrado);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.error("Tuvimos un problema. " + e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }
        return medicamentoRegistrado;
    }

    @Override
    public Medicamento buscarPorId(Long id) {
        Connection connection = null;
        Medicamento medicamentoEncontrado = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                medicamentoEncontrado = new Medicamento(resultSet.getLong(1), resultSet.getInt("codigo"), resultSet.getString("nombre"), resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"));
            }


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        if (medicamentoEncontrado != null) LOGGER.info("Se ha encontrado el medicamento " + medicamentoEncontrado);
        else LOGGER.error("No se encontro el medicamento con id " + id);

        return medicamentoEncontrado;
    }

}
