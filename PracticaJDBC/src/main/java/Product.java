import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Product {

    private long id;
    private String name;
    private String description;
    private Double price;
    private Date registeredDate;

    private Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getDouble("price"));
        product.setRegisteredDate(resultSet.getDate("registered_date"));
        return product;
    }

    public List<Product> list() {
        List<Product> products = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()
             ResultSet statement = connection.("SELECT * FROM products")
        {
            while (resultSet.next()) {
                products.add(createProduct(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
