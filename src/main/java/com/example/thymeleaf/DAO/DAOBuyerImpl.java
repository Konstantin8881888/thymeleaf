package com.example.thymeleaf.DAO;

import com.example.thymeleaf.entity.Buyer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DAOBuyerImpl implements DAOBuyer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Buyer> getAllBuyers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Buyer", Buyer.class).getResultList();
    }

    @Override
    public Buyer getBuyersById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Buyer.class, id);
    }

    @Override
    public void saveBuyer(Buyer buyer) {
        Session session = entityManager.unwrap(Session.class);
        session.save(buyer);
    }

    @Override
    public void deleteBuyer(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Buyer> query = session.createQuery("delete from Buyer where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
