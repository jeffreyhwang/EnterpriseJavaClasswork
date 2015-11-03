package edu.madisoncollege.enterprisejava.persistence;

import edu.madisoncollege.enterprisejava.entity.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
/**
 * @author YOUR NAME HERE
 * @version 1.0 10/20/15.
 */
public class EmployeeDao {

    public List<Employee> getAllEmployees() throws SQLException {

            List<Employee> employees = new ArrayList<Employee>();

            Connection connection = Database.getInstance().getConnection();

            String sql = "select * from employees order by emp_id";
            Statement selectStatement = connection.createStatement();

            ResultSet results = selectStatement.executeQuery(sql);

            while (results.next()) {
                int employeeId = results.getInt("emp_id");
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String socialSecurityNumber = results.getString("ssn");
                String department = results.getString("dept");
                String room = results.getString("room");
                String phone = results.getString("phone");

                Employee employee = new Employee(employeeId, firstName, lastName, socialSecurityNumber, department, room, phone);
                employees.add(employee);
            }

            results.close();
            selectStatement.close();

            return employees;
        }



    public Employee getEmployee(int employeeId) throws SQLException {

        Connection connection = Database.getInstance().getConnection();
        String sql = "select * from employees where emp_id = " + employeeId + " order by emp_id;";

        Statement selectStatement = connection.createStatement();
        Employee employee = null;


        ResultSet results = selectStatement.executeQuery(sql);
        while (results.next()) {
            String firstName = results.getString("first_name");
            String lastName = results.getString("last_name");
            String socialSecurityNumber = results.getString("ssn");
            String department = results.getString("dept");
            String room = results.getString("room");
            String phone = results.getString("phone");

            employee = new Employee(employeeId, firstName, lastName, socialSecurityNumber, department, room, phone);
        }

        return employee;

    }

    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = Database.getInstance().getConnection();

        Integer employeeId = employee.getEmployeeId();
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String socialSecurityNumber = employee.getSocialSecurityNumber();
        String department = employee.getDepartment();
        String room = employee.getRoom();
        String phone = employee.getPhone();

        String sql = "UPDATE employees SET " +
                "first_name='" + firstName +
                "', last_name='" + lastName +
                "', ssn='" + socialSecurityNumber +
                "', dept='" + department +
                "', room='" + room +
                "', phone='" + phone +
                "' WHERE emp_id = " + employeeId + ";";

        System.out.println(sql);
        Statement updateStatement = connection.createStatement();
        updateStatement.executeUpdate(sql);
        // TODO implement this method

    }
    public void deleteStudent(Employee employee) throws SQLException{
        // TODO implement this method
        Connection connection = Database.getInstance().getConnection();
        Integer employeeId = employee.getEmployeeId();
        String sql = "DELETE FROM employees WHERE emp_id = " + employeeId + ";";
        Statement deleteStatement = connection.createStatement();
        deleteStatement.executeUpdate(sql);
    }
}
