package com.ste.sdhapplication.contractmodule.repository;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.ordermodule.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractModel, Long> {
    List<ContractModel> findByUser_id(String userId);
    List<OrderModel> findByClient_clientId(long clientId);
}
