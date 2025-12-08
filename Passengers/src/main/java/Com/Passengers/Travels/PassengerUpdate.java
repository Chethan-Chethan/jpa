package Com.Passengers.Travels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerUpdate {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String updateQuery = "update passenger_info set Boarding_point = ? where Mode = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passengers", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1,"Goa");
            preparedStatement.setString(2,"Bus");
            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows affected " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
