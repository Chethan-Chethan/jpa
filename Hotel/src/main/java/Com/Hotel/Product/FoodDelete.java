package Com.Hotel.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodDelete {

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String deleteQuery = "delete from food_info where Price = ?;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,90);
//            preparedStatement.setInt(1,50);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
            if (connection != null) {
                try {
                    preparedStatement.close();
                    System.out.println("Statement closed successfully");
                    connection.close();
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
