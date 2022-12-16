package com.example.thymeleaf.DAO;

import com.example.thymeleaf.entity.Buyer;

import java.util.List;

public interface DAOBuyer {
    List<Buyer> getAllBuyers();
    Buyer getBuyersById(int id);
    void saveBuyer(Buyer buyer);
    void deleteBuyer(int id);
}
