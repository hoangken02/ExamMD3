package dao;

import model.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(Product product);

    List<Product> showAllProduct();

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    List<Product> searchProductById(int id);

    List<Product> searchProductByName(String name);
}
