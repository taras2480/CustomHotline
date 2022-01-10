package com.customHotline.customHotline.importProduct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductJson {

    private long id;

    private String sku;

    private String name;

    private String category_name;

    private long category_id;

    private double supl_price;

    private double price;

    private String stock;


}
