import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<Product> {
    default Connection getConnection() throws SQLException {
        return ConnectionDB.getInstance();
    }
    List<Product> listProducts();
    Product productsById(Long id);

    Product byId(Long id);

    void save(Product product);
    void delete(Long id);

}