package com.tts.ecommerceproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id // Specifies primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Key automatically generated
    @Column(name = "product_id") // Changes the name in database
    private Long id;

    private int quantity;
    private double price;
    private String description;
    private String name;
    private String brand;
    private String category;
    private String image;

    public Product() {
    }

    public Product(int quantity, double price, String description, String name, String brand, String category,
            String image) {
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.image = image;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", quantity='" + getQuantity() + "'" + ", price='" + getPrice() + "'"
                + ", description='" + getDescription() + "'" + ", name='" + getName() + "'" + ", brand='" + getBrand()
                + "'" + ", category='" + getCategory() + "'" + ", image='" + getImage() + "'" + "}";
    }
}
