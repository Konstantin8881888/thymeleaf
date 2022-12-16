package com.example.thymeleaf.controllers;

import com.example.thymeleaf.entity.Buyer;
import com.example.thymeleaf.entity.Product;
import com.example.thymeleaf.services.BuyerService;
import com.example.thymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ProductService productService;

    @GetMapping("/buyers")
    public String showAllBuyers(Model model) {
        List<Buyer> allBuyers = buyerService.getAllBuyers();
        model.addAttribute("allBuyers", allBuyers);
        return "allBuyers";
    }

    @GetMapping("/buyers/{id}")
    public String showBuyersInfo(@PathVariable int id, Model model) {
        Buyer buyersById = buyerService.getBuyersById(id);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("BuyerInfo", buyersById);
        model.addAttribute("buyersProduct", null);
        return "buyer_info";
    }


    @GetMapping("/buyers/newBuyer")
    public String newBuyer(Model model) {
        Buyer buyer = new Buyer();
        model.addAttribute("newBuyer", buyer);
        return "newBuyer";
    }

    @PostMapping("/buyers")
    public String addNewBuyer(Buyer buyer) {
        buyerService.saveBuyer(buyer);
        return "redirect:/buyers";
    }

    @DeleteMapping("/buyers/{id}")
    public String deleteBuyer(@PathVariable int id) {
        buyerService.deleteBuyer(id);
        return "redirect:/buyers";
    }


    @PatchMapping("/buyers/{id}/{productId}")
    public String saveBuyer(@PathVariable("id") int id, @PathVariable("productId") int id1) {
        Buyer buyersById = buyerService.getBuyersById(id);
        Product productById = productService.getProductById(id1);
        buyersById.addProductToBuyer(productById);
        buyerService.saveBuyer(buyersById);
        return "redirect:/buyers/" + id;
    }

    @DeleteMapping("/buyers/{id}/{productId}")
    public String deleteProductFromBuyer(@PathVariable("id") int id, @PathVariable("productId") int id1) {
        Buyer buyersById = buyerService.getBuyersById(id);
        Product productById = productService.getProductById(id1);
        buyersById.deleteProduct(productById);
        buyerService.saveBuyer(buyersById);
        return "redirect:/buyers/" + id;
    }
}
