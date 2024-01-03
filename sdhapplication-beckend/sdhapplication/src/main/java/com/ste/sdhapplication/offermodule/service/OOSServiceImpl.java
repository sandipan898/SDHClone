package com.ste.sdhapplication.offermodule.service;

import com.ste.sdhapplication.offermodule.model.OOSModel;
import com.ste.sdhapplication.offermodule.repository.OOSRepository;
import com.ste.sdhapplication.parmodule.model.ParModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OOSServiceImpl implements OOSService {
    @Autowired
    private OOSRepository oosRepository;

    @Override
    public List<OOSModel> getOOSByOffer(Long offerId) {
        return oosRepository.findByOffer_offerId(offerId);
    }

    @Override
    public HashMap<String, String> createOOS(OOSModel oosModel) {
        var createOOSMap = new HashMap<String, String>();
        try {
            OOSModel createdOOS = oosRepository.save(oosModel);
            createOOSMap.put("Status", "OK");
            createOOSMap.put("Message", "OOS Created Successfully!");
            createOOSMap.put("UserId", createdOOS.getOosID().toString());
            createOOSMap.put("Error", null);
        } catch (Exception e) {
            createOOSMap.put("Status", "KO");
            createOOSMap.put("Message", "Error Creating OOS!");
            createOOSMap.put("UserId", null);
            createOOSMap.put("Error", e.getMessage());
        }
        return createOOSMap;
    }

}
