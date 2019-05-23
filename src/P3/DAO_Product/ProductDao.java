package P3.DAO_Product;

import P3.POJO.Product;

import java.util.List;

public interface ProductDao {
    Product selectProduct(int productNummer);
    List<Product> selectProductenMetKaartnummer(int kaartnummer);
}
