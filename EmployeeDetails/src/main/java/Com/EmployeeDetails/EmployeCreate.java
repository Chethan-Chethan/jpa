package Com.EmployeeDetails;

import java.sql.*;

public class EmployeCreate {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver successfully loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/employee_detailis";
        String userName = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into emp_details( emp_id, emp_address, emp_salary) values (?, ?, ?);";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, psw);
            statement = connection.prepareStatement(query);
            statement.setInt(1, 18);
            statement.setString(2, "chintamani");
            statement.setInt(3, 15000);
//            statement.setInt(1, 44);
//            statement.setString(2, "kolar");
//            statement.setInt(3, 20000);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
            if (connection != null) {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
