package edu.madisoncollege.enterprisejava;

import edu.madisoncollege.enterprisejava.entity.Employee;
import edu.madisoncollege.enterprisejava.persistence.Database;
import edu.madisoncollege.enterprisejava.persistence.EmployeeDao;

import java.sql.SQLException;

/**
 * @author paulawaite
 * @version 1.0 10/20/15.
 */
public class EmployeeDriver {
    /** The main method is used to run the various
     *   Dao methods.
     *
     * @param args
     */
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        try {
            Database.getInstance().connect();
            System.out.println(dao.getAllEmployees());
            System.out.println(dao.getEmployee(109));
            System.out.println("Before: " + dao.getEmployee(101));
            Employee test = new Employee(101, "Jeffrey", "Hwang", "2133", "it", "204", "1231231234");
            dao.updateEmployee(test);
            System.out.println("After Update: " + dao.getEmployee(101));
            dao.deleteStudent(test);
            System.out.println("After Delete: " + dao.getEmployee(101));

            //TODO add code to call the other dao methods
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
