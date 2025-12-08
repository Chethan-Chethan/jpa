package Com.Ecom.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductCreate {

    public static                                                                                                                                                                                                     void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/ecom";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into product_info(product_id, Product_Name, Product_Price, Quantity) values (?, ?, ?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(url, userName, psw);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 7);
            preparedStatement.setString(2, "ink");
            preparedStatement.setInt(3, 120);
            preparedStatement.setInt(4, 10);
            preparedStatement.execute();
            System.out.println("Data inserted successfully");
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
        }
    }
}
