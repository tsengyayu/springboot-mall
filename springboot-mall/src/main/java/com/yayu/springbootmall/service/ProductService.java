package com.yayu.springbootmall.service;

import com.yayu.springbootmall.ProductCategory;
import com.yayu.springbootmall.dao.ProductDao;
import com.yayu.springbootmall.dto.ProductQueryParams;
import com.yayu.springbootmall.dto.ProductRequest;
import com.yayu.springbootmall.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);


}
