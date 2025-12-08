package Com.EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String deleteQuery = "delete from emp_details where emp_address = ? and emp_salary = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_detailis", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, "chintamani");
            preparedStatement.setInt(2, 15000);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows deleted " + rows);
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
