package com.bcc.gestao.bluevelvet.model.vo;

import com.bcc.gestao.bluevelvet.model.Product;

public class ProductVO {
    private Long id;
    private String name;
    private Double price;

    // Construtor padrão
    public ProductVO() {
    }

    // Construtor com todos os atributos
    public ProductVO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Método para converter VO em entidade
    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setPrice(this.price);
        return product;
    }
}
