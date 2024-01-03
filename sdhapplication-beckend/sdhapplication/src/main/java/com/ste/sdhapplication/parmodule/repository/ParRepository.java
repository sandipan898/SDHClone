package com.ste.sdhapplication.parmodule.repository;

import com.ste.sdhapplication.parmodule.model.ParModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParRepository extends JpaRepository<ParModel, Long> {
    Optional<ParModel> findByKey(String key);
    String findValueByKey(String key);
}
