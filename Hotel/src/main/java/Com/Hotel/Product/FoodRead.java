package Com.Hotel.Product;

import java.sql.*;

public class FoodRead {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement("select * from food_info");
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                System.out.println("Connection established Successfully");
                while (resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString("Name"));
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Price: " + resultSet.getInt("Price"));
                    System.out.println("Quantity: " + resultSet.getInt("quantity"));
                    System.out.println("Discount: " + resultSet.getInt("discount"));
                    System.out.println("-----------------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
