package com.example.thymeleaf.services;

import com.example.thymeleaf.DAO.DAOBuyer;
import com.example.thymeleaf.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private DAOBuyer daoBuyer;

    @Override
    @Transactional
    public List<Buyer> getAllBuyers() {
        return daoBuyer.getAllBuyers();
    }

    @Override
    @Transactional
    public Buyer getBuyersById(int id) {
        return daoBuyer.getBuyersById(id);
    }

    @Override
    @Transactional
    public void saveBuyer(Buyer buyer) {
        daoBuyer.saveBuyer(buyer);
    }

    @Override
    @Transactional
    public void deleteBuyer(int id) {
        daoBuyer.deleteBuyer(id);
    }
}