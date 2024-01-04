package com.ste.sdhapplication.offermodule.service;

import com.ste.sdhapplication.offermodule.model.OfferModel;
import com.ste.sdhapplication.offermodule.repository.OfferRepository;
import com.ste.sdhapplication.usermodule.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<OfferModel> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<OfferModel> getAllOffersByUser(String userId) {
        return offerRepository.findByUser_id(userId);
    }

    @Override
    public OfferModel getOfferById(long offerId) {
        return offerRepository.findById(offerId).orElse(new OfferModel());
    }

    @Override
    public HashMap<String, String> createOffer(OfferModel offerModel) {
        var createOfferMap = new HashMap<String, String>();
        try {
            OfferModel createdOffer = offerRepository.saveAndFlush(offerModel);
            createOfferMap.put("Status", "OK");
            createOfferMap.put("Message", "Offer Created Successfully!");
            createOfferMap.put("OfferId", createdOffer.getOfferID().toString());
            createOfferMap.put("Error", null);
        } catch (Exception e) {
            createOfferMap.put("Status", "KO");
            createOfferMap.put("Message", "Error Creating Offer!");
            createOfferMap.put("OfferId", null);
            createOfferMap.put("Error", e.getMessage());
        }
        return createOfferMap;
    }

    @Override
    public HashMap<String, String> updateOffer(long offerId, OfferModel offerModel) {
        var updateOfferMap = new HashMap<String, String>();
        offerModel.setOfferID(offerId);
        try {
            if(offerRepository.findById(offerId).isEmpty())
                throw new Exception("Given offer Id does not exist!");
            OfferModel createdOffer = offerRepository.saveAndFlush(offerModel);
            updateOfferMap.put("Status", "OK");
            updateOfferMap.put("Message", "Offer Updated Successfully!");
            updateOfferMap.put("Error", null);
        } catch (Exception e) {
            updateOfferMap.put("Status", "KO");
            updateOfferMap.put("Message", "Error Updating Offer!");
            updateOfferMap.put("Error", e.getMessage());
        }
        return updateOfferMap;
    }

    @Override
    public HashMap<String, String> deleteOffer(long offerId) {
        var deleteOfferMap = new HashMap<String, String>();
        try {
            if(offerRepository.findById(offerId).isEmpty())
                throw new Exception("Given offer Id does not exist!");
            offerRepository.deleteById(offerId);
            deleteOfferMap.put("Status", "OK");
            deleteOfferMap.put("Message", "Offer Deleted Successfully!");
            deleteOfferMap.put("Error", null);
        } catch (Exception e) {
            deleteOfferMap.put("Status", "KO");
            deleteOfferMap.put("Message", "Error Deleting Offer!");
            deleteOfferMap.put("Error", e.getMessage());
        }
        return deleteOfferMap;
    }
}
