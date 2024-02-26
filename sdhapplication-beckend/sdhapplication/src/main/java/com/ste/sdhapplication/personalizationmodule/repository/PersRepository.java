package com.ste.sdhapplication.personalizationmodule.repository;

import com.ste.sdhapplication.personalizationmodule.model.PersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PersRepository extends JpaRepository<PersModel, Long> {
    List<PersModel> findByMinPriceAndMaxPrice(BigDecimal minPrice, BigDecimal maxPrice);
    List<PersModel> findByMaxPriceGreaterThan(BigDecimal price);
    List<PersModel> findByMinPriceLessThan(BigDecimal price);
    List<PersModel> findByMaxPriceLessThanEqualAndMinPriceGreaterThanEqual(BigDecimal price1, BigDecimal price2);
}
