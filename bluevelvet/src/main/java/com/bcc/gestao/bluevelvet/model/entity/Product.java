package com.bcc.gestao.bluevelvet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;

    private String brand;

    private String category;

    private double price;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    private boolean stock;

    private double length;

    private double width;

    private double height;

    private double weight;

    private double cost;

    @Column(name = "detail_name")
    private String detailName;

    @Column(name = "detail_value")
    private String detailValue;
}

