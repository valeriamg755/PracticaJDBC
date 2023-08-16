package Repository.impl;

import java.sql.Connection;
import java.sql.SQLException;

public class RepositoryImpl {
    private Connection getConnection() throws SQLException {
        return ConnectionBD.getInstance();
    }
}
