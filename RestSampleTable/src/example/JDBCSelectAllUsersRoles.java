package example;
import java.sql.*;
/**
 * Created by Hwang on 10/12/15.
 */
public class JDBCSelectAllUsersRoles {



    public String runSample() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String output = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/SAMPLE", "tomcat", "tomcat");

            statement = connection.createStatement();

            String queryString = "SELECT * FROM user_roles";

            System.out.println("queryString: " + queryString);

            resultSet = statement.executeQuery(queryString);

            System.out.println();

            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String roleName = resultSet.getString("role_name");

                output += "\n userName: " + userName + " roleName: " + roleName;
            }

            System.out.println();



        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
        return output;
    }



    public String runSampleForSpecificUser(String userName) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String output = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/SAMPLE", "tomcat", "tomcat");

            statement = connection.createStatement();

            String queryString = "SELECT * FROM user_roles WHERE user_name = \"" + userName + "\"";

            System.out.println("queryString: " + queryString);

            resultSet = statement.executeQuery(queryString);

            System.out.println();
            output += "Roles for : " + userName;
            while (resultSet.next()) {
                String roleName = resultSet.getString("role_name");

                output += "\nroleName: " + roleName;
            }

            System.out.println();



        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
        return output;
    }

}

