package com.targetindia.DigitizeTimeTable.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionDao {
    Connection conn = null;

    static String url="jdbc:postgresql://localhost:5432/dtt";
    static String username="postgres";
    static String password="krishna";

    public ConnetionDao() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

}
