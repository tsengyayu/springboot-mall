package com.yayu.springbootmall.service.impl;

import com.yayu.springbootmall.dao.ProductDao;
import com.yayu.springbootmall.model.Product;
import com.yayu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
