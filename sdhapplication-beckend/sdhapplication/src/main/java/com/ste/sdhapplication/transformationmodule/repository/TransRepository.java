package com.ste.sdhapplication.transformationmodule.repository;

import com.ste.sdhapplication.transformationmodule.model.TransModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransRepository extends JpaRepository<TransModel, Long> {
}
