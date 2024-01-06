package com.ste.sdhapplication.ordermodule.service;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.ordermodule.model.OrderModel;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    List<OrderModel> getAllOrders();
    List<OrderModel> getAllOrdersByUser(String userId);
    List<OrderModel> getAllOrdersByClient(long clientId);
    OrderModel getOrderById(long orderId);
    HashMap<String, String> createOrder(OrderModel orderModel);
    HashMap<String, String> updateOrder(long orderId, OrderModel orderModel);
    HashMap<String, String> deleteOrder(long orderId);
}
