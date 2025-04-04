package com.mohit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mohit.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    List<Product> findByProductType(String productType);

    List<Product> findByPriceAndProductType(double price, String productType);

    //@Query(value = "SELECT * FROM PRODUCT_TBL WHERE price = ?1",nativeQuery = true)
    @Query("from Product p where p.price= ?1 ")
    //position based parameter
    //@Query("from PRODUCT_TABLE p where p.price= :price") //named parameter base index
    List<Product> getProductByPrice(double price);


    //prefix + field + operator

    List<Product> findByPriceIn(List<Double> prices);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByPriceLessThan(double price);

    List<Product> findByNameIgnoreCaseContaining(String name);

}