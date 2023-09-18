import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try(Connection conn = ConnectionDB.getInstance()){
            Repository<Product> repository = new Impl();
            repository.listProducts();
            repository.productsById(1L);
            //addProduct(repository);
            // updateProduct(repository);
            repository.delete(2L);
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}