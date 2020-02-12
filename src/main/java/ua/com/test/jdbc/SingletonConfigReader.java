package ua.com.test.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum SingletonConfigReader {
    INSTANCE;

    private Properties prop;
    private void reader() {

        String propFileName = "config.properties";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propFileName)) {

            prop = new Properties();
            prop.load(input);

            System.out.println(prop.getProperty("dbMysql.url"));
            System.out.println(prop.getProperty("dbMysql.user"));
            System.out.println(prop.getProperty("dbMysql.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Properties getProp() {
        if (prop==null) {
            reader();
        }
        return prop;
    }
}
