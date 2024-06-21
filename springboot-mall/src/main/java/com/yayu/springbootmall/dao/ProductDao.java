package com.yayu.springbootmall.dao;

import com.yayu.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}
