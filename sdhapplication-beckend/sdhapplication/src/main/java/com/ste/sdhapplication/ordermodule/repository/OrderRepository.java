package com.ste.sdhapplication.ordermodule.repository;

import com.ste.sdhapplication.ordermodule.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    List<OrderModel> findByUser_id(String userId);
    List<OrderModel> findByClient_clientId(long clientId);
}
