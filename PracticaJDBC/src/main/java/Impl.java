import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Impl implements Repository{

    private Product createProduct(ResultSet resultSet) throws
            SQLException {
        Product producto = new Product();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro")
                .toLocalDate());
        return producto;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return Repository.super.getConnection();
    }

    @Override
    public List<Product> listProducts() {
        List<Product> productList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from productos")) {
            while (resultSet.next()) {
                Product producto = createProduct(resultSet);
                productList.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return productList;
    }

    @Override
    public Object productsById(Long id) {
        return null;
    }

    @Override
    public Object byId(Long id) {
        Product product = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM productos WHERE id =?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = createProduct(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Object o){
    }

    @Override
    public void delete(Long id) {

    }
}