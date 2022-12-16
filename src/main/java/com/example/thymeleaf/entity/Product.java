package com.example.thymeleaf.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buyer_products",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_buyer"))
    private List<Buyer> buyerList;

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product() {
    }

    public void addBuyerForProduct(Buyer buyer) {
        if (buyerList == null) {
            buyerList = new ArrayList<>();
        }
        buyerList.add(buyer);
    }

    public List<Buyer> getBuyerList() {
        return buyerList;
    }

    public void setBuyerList(List<Buyer> buyerList) {
        this.buyerList = buyerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}