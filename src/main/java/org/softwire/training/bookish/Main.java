package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.softwire.training.bookish.models.database.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
        }
      }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        Jdbi jdbi = Jdbi.create(connectionString);

        List<Book> books = jdbi.withHandle(handle -> {
            handle.registerRowMapper(ConstructorMapper.factory(Book.class));
            return handle.createQuery("select * from book")
                .mapTo(Book.class)
                .list();
        });

        books.forEach(System.out::println);
    }
}
