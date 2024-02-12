package com.ste.sdhapplication.cremodule.service;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.cremodule.model.CreModel;

import java.util.HashMap;
import java.util.List;

public interface CreService {
    List<CreModel> getAllDealers();
    CreModel getDealerById(String codCre);
    HashMap<String, String> createDealer(CreModel creModel);
    HashMap<String, String> updateDealer(CreModel creModel, String codCre);
    HashMap<String, String> deleteDealer(String codCre);
}
