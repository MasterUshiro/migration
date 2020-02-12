package ua.com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public enum SingletonEnumPostgress {
    INSTANCE;

    public Connection getConnection() {
        Map<String, String> map = System.getenv();
        Connection res = null;
        SingletonConfigReader config = SingletonConfigReader.INSTANCE;

        config.getProp();

        try {
            Class.forName("org.postgresql.Driver");
            res = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/simplewsp", "postgres", "pass");

        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

}
