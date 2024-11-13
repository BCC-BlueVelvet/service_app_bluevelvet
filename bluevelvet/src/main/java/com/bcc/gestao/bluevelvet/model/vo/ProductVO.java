package com.bcc.gestao.bluevelvet.model.vo;

import com.bcc.gestao.bluevelvet.model.entity.Product;

public class ProductVO {

    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;

    // Construtor padrão
    public ProductVO() {}

    // Construtor com todos os atributos
    public ProductVO(int id, String name, String brand, String category, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    // Getters e Setters
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Função para transformar o VO em uma entidade Product
    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setBrand(this.brand);
        product.setCategory(this.category);
        product.setPrice(this.price);
        return product;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
