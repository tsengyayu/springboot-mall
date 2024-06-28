package com.yayu.springbootmall.dao;

import com.yayu.springbootmall.dto.ProductRequest;
import com.yayu.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
