package com.bcc.gestao.bluevelvet.model.vo;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductVO {

    private int id;

    private String name;

    private String brand;

    private String category;

    private double price;

    private String pictureUrl;

    private String shortDescription;

    private String fullDescription;

    private boolean stock;

    private double length;

    private double width;

    private double height;

    private double weight;

    private double cost;

    private String detailName;

    private String detailValue;

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setBrand(this.brand);
        product.setCategory(this.category);
        product.setPrice(this.price);
        product.setPictureUrl(this.pictureUrl);
        product.setShortDescription(this.shortDescription);
        product.setFullDescription(this.fullDescription);
        product.setStock(this.stock);
        product.setLength(this.length);
        product.setWidth(this.width);
        product.setHeight(this.height);
        product.setWeight(this.weight);
        product.setCost(this.cost);
        product.setDetailName(this.detailName);
        product.setDetailValue(this.detailValue);
        return product;
    }
}
