package com.ste.sdhapplication.offermodule.service;

import com.ste.sdhapplication.offermodule.model.OOSModel;
import com.ste.sdhapplication.offermodule.repository.OOSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OOSServiceImpl implements OOSService {
    @Autowired
    private OOSRepository oosRepository;

    @Override
    public List<OOSModel> getOOSByOffer(Long offerId) {
        return oosRepository.findByOffer_offerId(offerId);
    }

}
