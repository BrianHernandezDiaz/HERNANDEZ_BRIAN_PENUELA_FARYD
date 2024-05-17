package com.backend.parcial.repository.impl;

import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.repository.IDao;
import com.backend.parcial.repository.dbconnection.H2Connection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        String insert = "INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES(?, ?, ?)";

        Connection connection = null;
        Odontologo odontologoRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNumero_matricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.execute();

            //connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                odontologoRegistrado = new Odontologo(resultSet.getLong("id"), odontologo.getNumero_matricula(), odontologo.getNombre(), odontologo.getApellido());
            }
            connection.commit();
            LOGGER.info("Odontologo guardado: " + odontologoRegistrado);

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
        return odontologoRegistrado;
    }

    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = null;
        List<Odontologo> Odontologos = new ArrayList<>();
        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Odontologo Odontologo = crearObjetoOdontologo(resultSet);
                Odontologos.add(Odontologo);
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
        LOGGER.info("Listado de todos los Odontologos: " + Odontologos);

        return Odontologos;
    }

    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {

        return new Odontologo(resultSet.getLong("id"), resultSet.getInt("numero_matricula"), resultSet.getString("nombre"), resultSet.getString("apellido"));
    }

}
