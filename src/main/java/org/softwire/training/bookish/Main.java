package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "bookish";
        String user = "dave";
        String password = "admin";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false";

        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);

        viewTable(connection);

    }

    public static void viewTable(Connection con) throws SQLException {
        String query = "select * from BOOK";
        try (Statement stmt = con.createStatement()) {
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
            String isbn = rs.getString("ISBN");
            String title = rs.getString("TITLE");
            String author = rs.getString("AUTHOR");
            System.out.println(isbn + ", " + title + ", " + author);
          }
        } catch (SQLException e) {
            e.printStackTrace();
        //   JDBCTutorialUtilities.printSQLException(e);
        }
      }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);



    }
}
