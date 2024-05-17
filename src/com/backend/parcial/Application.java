package com.backend.parcial;

import com.backend.parcial.repository.dbconnection.H2Connection;
import org.apache.log4j.Logger;

import java.sql.*;



public class Application {

    public static void main(String[] args) {
        H2Connection.crearTablas();

    }

}
