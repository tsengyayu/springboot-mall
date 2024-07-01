package com.yayu.springbootmall.dao;

import com.yayu.springbootmall.ProductCategory;
import com.yayu.springbootmall.dto.ProductQueryParams;
import com.yayu.springbootmall.dto.ProductRequest;
import com.yayu.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);

    void updateStock(Integer productId, Integer stock);

}
