package com.ste.sdhapplication.offermodule.service;

import com.ste.sdhapplication.offermodule.model.OfferModel;
import com.ste.sdhapplication.usermodule.model.UserModel;

import java.util.HashMap;
import java.util.List;

public interface OfferService {
    List<OfferModel> getAllOffers();
    List<OfferModel> getAllOffersByUser(String userId);
    List<OfferModel> getAllOffersByClient(long clientId);
    List<OfferModel> getAllOffersByDealer(String codCre);
    OfferModel getOfferById(long offerId);
    HashMap<String, String> createOffer(OfferModel offerModel);
    HashMap<String, String> updateOffer(long offerId, OfferModel offerModel);
    HashMap<String, String> deleteOffer(long offerId);
}
