package com.ste.sdhapplication.offermodule.repository;

import com.ste.sdhapplication.offermodule.model.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel, Long> {
    List<OfferModel> findByUser_id(String userId);
}
