package ua.com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public enum SingletonEnumMysql {
    INSTANCE;

    public Connection getConnection() {

        Connection res = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            res = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/simplews", "root", "pass");

        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

}
