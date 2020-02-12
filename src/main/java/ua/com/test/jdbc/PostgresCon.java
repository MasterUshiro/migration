package ua.com.test.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresCon {

    public static void main(String args[]) {
        System.out.println("POstgress TEst");
        SingletonEnumPostgress singleton = SingletonEnumPostgress.INSTANCE;

        try {
            Statement stmt = singleton.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from languages");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
