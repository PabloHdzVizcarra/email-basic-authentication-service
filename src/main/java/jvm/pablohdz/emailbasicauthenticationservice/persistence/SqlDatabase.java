package jvm.pablohdz.emailbasicauthenticationservice.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jvm.pablohdz.emailbasicauthenticationservice.service.Database;

public class SqlDatabase implements Database {
    private final String DB_URL = "jdbc:h2:~/test";
    private final String USER = "sa";
    private final String PASSWORD = "sa";

    public SqlDatabase() {
        prepareDatabase();
    }

    @Override
    public void create() {
    }

    private Statement createStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private void prepareDatabase() {
        Connection conn = createConnection();
        Statement stmt = createStatement(conn);
        String queryCreateDatabase = "CREATE TABLE IF NOT EXISTS user (" +
                "user_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                "user_name VARCHAR(255) NOT NULL );";

        executeQuery(stmt, queryCreateDatabase);
        System.out.println("database user is created");
    }

    private void executeQuery(Statement statement, String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }


}
