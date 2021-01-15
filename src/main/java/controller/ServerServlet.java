package controller;

import dao.ProductService;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServerServlet", urlPatterns = "/server")
public class ServerServlet extends HttpServlet {
    ProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request, response);
                break;
            case "update":
                showEditProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.showAllProduct();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/listProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        String category = request.getParameter("category");
        Product product = new Product(name, price, quantity, color, status, category);
productService.addProduct(product);
RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/listProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/createProduct.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        String category = request.getParameter("category");
        Product product = new Product(name, price, quantity, color, status, category);
        productService.updateProduct(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/listProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);

        List<Product> productList = productService.showAllProduct();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/listProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.searchProductById(id);
        request.setAttribute("editProduct", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/updateProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        Product product = productService.searchProductByName(name);
        List<Product> productlist = new ArrayList<>();
        productlist.add(product);
        request.setAttribute("productList", productlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/listProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
