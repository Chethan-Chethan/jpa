package Com.EcomPractice.Product;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductRunnerPractice {

    public static void main(String[] args) {

        String url = "jdbc:mysql:";
        String unmae = "";
        String pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        Connection con = DriverManager.getConnection()
    }
}
