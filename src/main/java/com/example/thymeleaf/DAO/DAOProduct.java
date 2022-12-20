package com.example.thymeleaf.DAO;

import com.example.thymeleaf.entity.Product;

import java.util.List;

public interface DAOProduct {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void saveProduct(Product product);
    void deleteProduct(int id);
}