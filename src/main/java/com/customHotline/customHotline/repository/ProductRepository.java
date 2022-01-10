package com.customHotline.customHotline.repository;

import com.customHotline.customHotline.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>,
        JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Modifying
    @Query( value ="INSERT INTO product (id_feed, sku, name, category_id, category_name,  supl_price, price, availability) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
            nativeQuery = true)
    void insertDataFromFile(

            @Param("id_feed")long idFeed,
            @Param("sku")String sku,
            @Param("name")String name,
            @Param("category_id")long categoryId,
            @Param("category_name")String categoryName,
            @Param("supl_price")double suplPrice,
            @Param("price")double price,
            @Param("availability")String availability

    );
}
