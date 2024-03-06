package com.ste.sdhapplication.parmodule.service;

import com.ste.sdhapplication.parmodule.model.ParModel;

import java.util.HashMap;
import java.util.List;

public interface ParService {
    List<ParModel> getAllParameter();
    ParModel getParameterById(Long id);
    ParModel getParameterByKey(String key);
    String getParameterValueByKey(String key);
    HashMap<String, String> createParameter(ParModel parModel);
    HashMap<String, String> updateParameter(ParModel parModel, Long id);
    HashMap<String, String> deleteParameter(Long id);
}
