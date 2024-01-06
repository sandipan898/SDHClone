package com.ste.sdhapplication.vehiclemodule.repository;

import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<VersionModel, String> {
    List<VersionModel> findByFamily_code(String family);
    List<VersionModel> findByCarType(String carType);
}
