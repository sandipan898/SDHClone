package com.ste.sdhapplication.offermodule.repository;

import com.ste.sdhapplication.offermodule.model.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferModel, Long> {
}
