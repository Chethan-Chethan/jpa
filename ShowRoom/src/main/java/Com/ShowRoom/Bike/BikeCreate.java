package Com.ShowRoom.Bike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BikeCreate {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/bike_showroom";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into bike_details(chassis_numb, engine_numb, bike_price) values (?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(url, userName, psw);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "56tyt554e3w778");
            preparedStatement.setString(2, "890765tgf432");
            preparedStatement.setDouble(3, 300000);
            preparedStatement.execute();
            System.out.println("Successfully executed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    System.out.println("Successfully closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Successfully connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
