package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";

    //  Database credentials
    public static final String USER = "sa";
    public static final String PASS = "";

    public static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connection established successfully");
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return conn;
    }
}
