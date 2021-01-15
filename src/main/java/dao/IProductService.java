package dao;

import model.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(Product product);

    List<Product> showAllProduct();

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    Product searchProductById(int id);

    Product searchProductByName(String name);

}
