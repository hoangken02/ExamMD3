package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private final String ADD_PRODUCT = "INSERT INTO product" + "  (name, prime, quantity,color,status,category) VALUES " +
            " (?, ?, ?, ?, ?, ?):";
    private final String SHOW_ALL_PRODUCT = "select * from product";
    private final String UPDATE_PRODUCT = "update product set Name = ?,Prime = ?, Quantity = ?,Color =? , Status = ?, Category = ?  where id = ?;";
    private final String DELETE_PRODUCT = "delete from product where id = ?;";
    private final String SEARCH_PRODUCT_BY_ID = "select * from product where id = ?";
    private final String SEARCH_PRODUCT_BY_NAME = "select * from product where name = ?";
    Connection connection = ConnectDB.getConnection();

    @Override
    public boolean addProduct(Product product) {
        boolean addProduct = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setString(6, product.getCategory());
            addProduct = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addProduct;
    }

    @Override
    public List<Product> showAllProduct() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL_PRODUCT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String prime = resultSet.getString("prime");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String status = resultSet.getString("status");
                String category = resultSet.getString("category");
                products.add(new Product(id, name, prime, quantity, color, status, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean updateProduct = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, "name");
            preparedStatement.setString(2, "prime");
            preparedStatement.setString(3, "quantity");
            preparedStatement.setString(4, "color");
            preparedStatement.setString(5, "status");
            preparedStatement.setString(6, "category");
            updateProduct = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateProduct;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean deleteProduct = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, id);
            deleteProduct = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteProduct;
    }

    @Override
    public Product searchProductById(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String prime = resultSet.getString("prime");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String status = resultSet.getString("status");
                String category = resultSet.getString("categoryId");
                product = new Product(name, prime, quantity, color, status, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product searchProductByName(String name) {
        return null;
    }
}

