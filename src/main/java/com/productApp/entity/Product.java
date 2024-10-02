package com.productApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @Column(name = "pname", nullable = false)
    private String pname;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    public Product(String pname, double price, double quantity) {
        super();
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
    }
}
