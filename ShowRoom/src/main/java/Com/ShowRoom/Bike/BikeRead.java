package Com.ShowRoom.Bike;

import java.sql.*;

public class BikeRead {
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bike_showroom", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement("select * from bike_details");
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                System.out.println("Connection established " + resultSet);
                while (resultSet.next()) {
                    System.out.println("Bike Name: " + resultSet.getString("bike_name"));
                    System.out.println("Chassis number: " + resultSet.getString("chassis_numb"));
                    System.out.println("Engine Number: " + resultSet.getString("engine_numb"));
                    System.out.println("Bike Price: " + resultSet.getInt("bike_price"));
                    System.out.println("Milage: " + resultSet.getInt("milage"));
                    System.out.println("-----------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
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
