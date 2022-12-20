package com.example.thymeleaf.services;

import com.example.thymeleaf.DAO.DAOProduct;
import com.example.thymeleaf.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private DAOProduct daoProduct;

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return daoProduct.getAllProducts();
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return daoProduct.getProductById(id);
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        daoProduct.saveProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        daoProduct.deleteProduct(id);
    }
}