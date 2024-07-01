package com.yayu.springbootmall.service;

import com.yayu.springbootmall.dto.CreateOrderRequest;
import com.yayu.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
