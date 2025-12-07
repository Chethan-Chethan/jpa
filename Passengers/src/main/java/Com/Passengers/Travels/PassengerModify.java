package Com.Passengers.Travels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerModify {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/passengers";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into passenger_info(Mode, Ticket_numb, Boarding_point, Destination_point) values (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(url, userName, psw);
            System.out.println("Connection established");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Ship");
            preparedStatement.setInt(2, 77899076);
            preparedStatement.setString(3, "Goa");
            preparedStatement.setString(4, "Maldives");
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
                    System.out.println("Successfully closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
