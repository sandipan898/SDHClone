package com.ste.sdhapplication.cremodule.repository;

import com.ste.sdhapplication.cremodule.model.CreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreRepository extends JpaRepository<CreModel, String> {
}
