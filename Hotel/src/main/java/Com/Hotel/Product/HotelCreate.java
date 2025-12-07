package Com.Hotel.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HotelCreate {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/hotel";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into food_info (id, Price) values (?, ?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, userName, psw);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 166);
            preparedStatement.setInt(2, 878);
            preparedStatement.execute();
            System.out.println("Successfully executed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
