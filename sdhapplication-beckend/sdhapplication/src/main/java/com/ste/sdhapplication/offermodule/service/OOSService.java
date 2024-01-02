package com.ste.sdhapplication.offermodule.service;

import com.ste.sdhapplication.offermodule.model.OOSModel;
import com.ste.sdhapplication.offermodule.model.OfferModel;

import java.util.HashMap;
import java.util.List;

public interface OOSService {
    List<OOSModel> getOOSByOffer(Long offerId);
}
