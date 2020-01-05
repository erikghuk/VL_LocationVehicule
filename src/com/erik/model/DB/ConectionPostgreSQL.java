package com.erik.model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConectionPostgreSQL {
    private static String url = "jdbc:postgresql://localhost:5432/Test";
    private static String user = "Erik";
    private static String pass = "055340";
    private static Connection connect;

    static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
