package com.ste.sdhapplication.personalization.service;

import com.ste.sdhapplication.parmodule.model.ParModel;
import com.ste.sdhapplication.personalization.model.PersModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface PersService {
    List<PersModel> getAllPersonalization();
    PersModel getPersonalizationById(long id);
    List<PersModel> getPersonalizationByRange(BigDecimal minVal, BigDecimal maxVal);
    List<PersModel> getPersonalizationByPrice(BigDecimal price);
    HashMap<String, String> createParameter(PersModel persModel);
    HashMap<String, String> updateParameter(PersModel persModel, long id);
    HashMap<String, String> deleteParameter(long id);
}
