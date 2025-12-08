package Com.ShowRoom.Bike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BikeUpdate {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String updateQuery = "update bike_details set bike_price = ?, milage = ? where bike_name = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bike_showroom", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, 250000);
            preparedStatement.setInt(2, 40);
            preparedStatement.setString(3, "Ns-200");
            int entries = preparedStatement.executeUpdate();
            System.out.println("Deleted entries " + entries);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    System.out.println("Statement successfully closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection successfully closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
