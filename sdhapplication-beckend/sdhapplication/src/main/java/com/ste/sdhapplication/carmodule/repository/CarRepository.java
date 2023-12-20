package com.ste.sdhapplication.carmodule.repository;

import com.ste.sdhapplication.carmodule.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, String> {
    List<CarModel> findByFamily(String family);
}
