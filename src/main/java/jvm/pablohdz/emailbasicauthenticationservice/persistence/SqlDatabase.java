package jvm.pablohdz.emailbasicauthenticationservice.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jvm.pablohdz.emailbasicauthenticationservice.controller.UserRequest;
import jvm.pablohdz.emailbasicauthenticationservice.service.Database;

public class SqlDatabase implements Database {
    private final EnvDatabase env;

    public SqlDatabase(EnvDatabase env) {
        this.env = env;
    }

    @Override
    public long create(UserRequest data) {
        Connection connection = createConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "insert into user(user_name, user_lastname, " +
                            "user_username, user_email, user_password, user_created) " +
                            "values (?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            pstmt.setString(1, data.getName());
            pstmt.setString(2, data.getLastname());
            pstmt.setString(3, data.getUsername());
            pstmt.setString(4, data.getEmail());
            pstmt.setString(5, data.getPassword());
            pstmt.setTimestamp(6, data.getCreateAt());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            long idCreated = 0;

            if (rs.next()) {
                idCreated = rs.getLong(1);
            }

            return idCreated;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private Statement createStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private void closeConnections(Statement stmt, Connection conn) {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeQuery(Statement statement, String query) {
        try {
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(env.getUrlDatabase(), env.getUserDatabase(),
                    env.getPasswordDatabase()
            );
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
