package dao;

import exception.MedsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String USERNAME = "crud_meds";
    private static final String PASSWORD = "crud_meds";
    private static final String SCHEMA = "crud_meds";

    public static Connection getConnection() {

        String uri = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, SCHEMA);
        System.out.println("Connection to " + uri + " successful!");
        try {
            Connection conn = DriverManager.getConnection(uri, USERNAME, PASSWORD);

            return conn;
        } catch (SQLException e) {
            System.err.println("Could not connect to " + uri);
            throw new MedsException(e);
        }
    }

}