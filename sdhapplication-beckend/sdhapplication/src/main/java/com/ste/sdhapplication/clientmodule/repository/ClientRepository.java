package com.ste.sdhapplication.clientmodule.repository;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    List<ClientModel> findByType(String type);
}
