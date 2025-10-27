package com.app.warehouse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String size;
    private BigDecimal price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
}