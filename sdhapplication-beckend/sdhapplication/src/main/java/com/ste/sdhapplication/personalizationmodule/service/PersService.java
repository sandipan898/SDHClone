package com.ste.sdhapplication.personalizationmodule.service;

import com.ste.sdhapplication.personalizationmodule.model.PersModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface PersService {
    List<PersModel> getAllPersonalization();
    PersModel getPersonalizationById(long id);
    List<PersModel> getPersonalizationByRange(BigDecimal minVal, BigDecimal maxVal);
    List<PersModel> getPersonalizationByPrice(BigDecimal price);
    HashMap<String, String> createPersonalization(PersModel persModel);
    HashMap<String, String> updatePersonalization(PersModel persModel, long id);
    HashMap<String, String> deletePersonalization(long id);
}
