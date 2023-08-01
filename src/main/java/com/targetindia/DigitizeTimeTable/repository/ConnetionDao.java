package com.targetindia.DigitizeTimeTable.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDao {
    Connection conn = null;

    static String url="jdbc:postgresql://localhost:5432/dtt";
    static String username="postgres";
    static String password="krishna";

    public Connection getDBConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return conn;
    }

}
