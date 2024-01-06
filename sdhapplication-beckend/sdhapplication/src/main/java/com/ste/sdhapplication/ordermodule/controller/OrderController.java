package com.ste.sdhapplication.ordermodule.controller;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.contractmodule.service.ContractService;
import com.ste.sdhapplication.ordermodule.model.OrderModel;
import com.ste.sdhapplication.ordermodule.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/")
    public List<OrderModel> list() {
        logger.info("Accessing list() -> GET : api/v1/order/");
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderModel getById(@PathVariable Long orderId) {
        logger.info("Accessing getById() -> GET : api/v1/order/{orderId}");
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/by_user/{userId}")
    public List<OrderModel> getByUserId(@PathVariable String userId) {
        logger.info("Accessing getByUserId() -> GET : api/v1/order/by_user/{userId}");
        return orderService.getAllOrdersByUser(userId);
    }

    @GetMapping("/by_client/{clientId}")
    public List<OrderModel> getByClientId(@PathVariable long clientId) {
        logger.info("Accessing getByClientId() -> GET : api/v1/order/by_client/{clientId}");
        return orderService.getAllOrdersByClient(clientId);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final OrderModel orderModel) {
        logger.info("Accessing create() -> POST : api/v1/order/");
        return orderService.createOrder(orderModel);
    }

    @PutMapping("/{orderId}")
    public HashMap<String, String> update(@PathVariable Long orderId, @RequestBody final OrderModel orderModel) {
        logger.info("Accessing update() -> PUT : api/v1/order/{orderId}");
        return orderService.updateOrder(orderId, orderModel);
    }

    @DeleteMapping("/{orderId}")
    public HashMap<String, String> delete(@PathVariable Long orderId) {
        logger.info("Accessing delete() -> DELETE : api/v1/order/{orderId}");
        return orderService.deleteOrder(orderId);
    }
}
