package Com.Hotel.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodInfo {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/hotel";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into food_info values ('3', 213, 50, 4, 2);";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, psw);
            statement = connection.createStatement();
            boolean ref = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
