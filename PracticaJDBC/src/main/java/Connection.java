import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password= "admin";
    try (
    java.sql.Connection conn = DriverManager.getConection(url, user, password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
        ){
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("price"));
            System.out.println(resultSet.getInt("register_date"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
