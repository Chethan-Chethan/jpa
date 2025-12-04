package Com.Passengers.Travels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerDetails {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/passengers";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into passenger_info values ('AeroPlane', 981934, 'KA89-61-HIIOUH-9650', 'Bengaluru', 'SwizerLand');";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, psw);
            statement = connection.createStatement();
            boolean ref = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Successfully executed");
    }
}
