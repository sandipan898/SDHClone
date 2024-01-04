package com.ste.sdhapplication.offermodule.repository;

import com.ste.sdhapplication.offermodule.model.OOSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OOSRepository extends JpaRepository<OOSModel, Long> {
    List<OOSModel> findByOffer_offerID(Long offerId);
}
