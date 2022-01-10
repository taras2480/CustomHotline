package com.customHotline.customHotline.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_feed")
    private long idFeed;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "supl_price")
    private Double suplPrice;

    @Column(name = "price")
    private Double price;

    @Column(name = "availability")
    private String availability;

    @Column(name = "check_link" )
    private String checkLink;

    @Column(name = "status_product")
    private long statusProduct;

    @Column(name = "check")
    private boolean check;



}

