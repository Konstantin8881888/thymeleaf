package com.example.thymeleaf.DAO;

import com.example.thymeleaf.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DAOProductImpl implements DAOProduct {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Product.class, id);
    }

    @Override
    public void saveProduct(Product product) {
        Session session = entityManager.unwrap(Session.class);
        session.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Product> query = session.createQuery("delete from Product where id =:productId");
        query.setParameter("productId", id);
        query.executeUpdate();
    }
}