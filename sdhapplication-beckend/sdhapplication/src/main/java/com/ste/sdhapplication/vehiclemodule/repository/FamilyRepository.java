package com.ste.sdhapplication.vehiclemodule.repository;

import com.ste.sdhapplication.vehiclemodule.model.FamilyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyModel, String> {
    List<FamilyModel> findByUserCre_dealerId(String dealerId);
}
