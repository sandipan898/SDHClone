package com.ste.sdhapplication.ordermodule.service;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.ordermodule.model.OrderModel;
import com.ste.sdhapplication.ordermodule.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderModel> getAllOrdersByUser(String userId) {
        return orderRepository.findByUser_id(userId);
    }

    @Override
    public List<OrderModel> getAllOrdersByClient(long clientId) {
        return orderRepository.findByClient_clientId(clientId);
    }

    @Override
    public OrderModel getOrderById(long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public HashMap<String, String> createOrder(OrderModel orderModel) {
        var createOrderMap = new HashMap<String, String>();
        try {
            OrderModel createdOrder = orderRepository.saveAndFlush(orderModel);
            createOrderMap.put("Status", "OK");
            createOrderMap.put("Message", "Order Created Successfully!");
            createOrderMap.put("OrderModel", createdOrder.getId().toString());
            createOrderMap.put("Error", null);
        } catch (Exception e) {
            createOrderMap.put("Status", "KO");
            createOrderMap.put("Message", "Error Creating Order!");
            createOrderMap.put("OrderModel", null);
            createOrderMap.put("Error", e.getMessage());
        }
        return createOrderMap;
    }

    @Override
    public HashMap<String, String> updateOrder(long orderId, OrderModel orderModel) {
        var updateOrderMap = new HashMap<String, String>();
        orderModel.setId(orderId);
        try {
            if(orderRepository.findById(orderId).isEmpty())
                throw new Exception("Given Order Id does not exist!");
            orderRepository.saveAndFlush(orderModel);
            updateOrderMap.put("Status", "OK");
            updateOrderMap.put("Message", "Order Updated Successfully!");
            updateOrderMap.put("Error", null);
        } catch (Exception e) {
            updateOrderMap.put("Status", "KO");
            updateOrderMap.put("Message", "Error Updating Order!");
            updateOrderMap.put("Error", e.getMessage());
        }
        return updateOrderMap;
    }

    @Override
    public HashMap<String, String> deleteOrder(long orderId) {
        var deleteOrderMap = new HashMap<String, String>();
        try {
            if(orderRepository.findById(orderId).isEmpty())
                throw new Exception("Given Order Id does not exist!");
            orderRepository.deleteById(orderId);
            deleteOrderMap.put("Status", "OK");
            deleteOrderMap.put("Message", "Order Deleted Successfully!");
            deleteOrderMap.put("Error", null);
        } catch (Exception e) {
            deleteOrderMap.put("Status", "KO");
            deleteOrderMap.put("Message", "Error Deleting Order!");
            deleteOrderMap.put("Error", e.getMessage());
        }
        return deleteOrderMap;
    }
}
