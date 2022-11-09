package com.tms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection provideConnection(){

        Connection connect= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        String url= "jdbc:mysql://localhost:3306/tms";

        try {
            connect= DriverManager.getConnection(url, "root", "King@32911");
        } catch (SQLException e) {

            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        return connect;
    }
}
