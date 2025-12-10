package Com.Ecom.Product;

import java.sql.*;

public class ProductRead {

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement("select * from product_info where Product_Price > ?");
            preparedStatement.setInt(1, 50);
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                System.out.println("Connection established Successfully " + resultSet);
                System.out.println("Product ID | Product Name | Product Price | Product Quantity");
                while (resultSet.next()) {
//                    System.out.println(resultSet.getInt("Product_id") + " | " + resultSet.getString("Product_Name") + " | " + resultSet.getInt("Product_Price") + " | " + resultSet.getInt("Quantity"));
                    System.out.println("Product ID: " + resultSet.getInt("Product_id"));
                    System.out.println("Product Name: " + resultSet.getString("Product_Name"));
                    System.out.println("Product Price: " + resultSet.getInt("Product_Price"));
                    System.out.println("Product Quantity: " + resultSet.getInt("Quantity"));
                    System.out.println("---------------------------------------------------------------");
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
        }
    }
}
