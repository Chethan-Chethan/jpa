package Com.Passengers.Travels;

import java.sql.*;

public class PassengerRead {
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passengers", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement("select * from passenger_info");
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                System.out.println("Connection established " + resultSet);
                while (resultSet.next()) {
                    System.out.println("Mode " + resultSet.getString("Mode"));
                    System.out.println("Ticket Numb " + resultSet.getInt("Ticket_numb"));
                    System.out.println("Vehicle Number " + resultSet.getString("Vehicle_numb"));
                    System.out.println("Boarding Point " + resultSet.getString("Boarding_point"));
                    System.out.println("Destination " + resultSet.getString("Destination_point"));
                    System.out.println("---------------------------------------------------------------");
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
