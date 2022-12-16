package com.example.thymeleaf.services;

import com.example.thymeleaf.entity.Buyer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuyerService {
    List<Buyer> getAllBuyers();
    Buyer getBuyersById(int id);
    void saveBuyer(Buyer buyer);
    void deleteBuyer(int id);
}