package com.yayu.springbootmall.service;

import com.yayu.springbootmall.dto.CreateOrderRequest;
import com.yayu.springbootmall.dto.OrderQueryParams;
import com.yayu.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    Order getOrderById(Integer orderId);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer countOrder(OrderQueryParams orderQueryParams);
}
