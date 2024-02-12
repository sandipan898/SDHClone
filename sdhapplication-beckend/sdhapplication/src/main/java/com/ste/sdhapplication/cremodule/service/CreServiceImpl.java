package com.ste.sdhapplication.cremodule.service;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.cremodule.model.CreModel;
import com.ste.sdhapplication.cremodule.repository.CreRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CreServiceImpl implements CreService {
    @Autowired
    private CreRepository creRepository;

    @Override
    public List<CreModel> getAllDealers() {
        return creRepository.findAll();
    }

    @Override
    public CreModel getDealerById(String codCre) {
        return creRepository.findById(codCre).orElse(null);
    }

    @Override
    public HashMap<String, String> createDealer(CreModel creModel) {
        var createDealerMap = new HashMap<String, String>();
        try {
            if (creRepository.findById(creModel.getCodCre()).isPresent())
                throw new Exception("Dealer with given ID already exists!");
            CreModel createdDealer = creRepository.save(creModel);
            createDealerMap.put("Status", "OK");
            createDealerMap.put("Message", "Dealer Created Successfully!");
            createDealerMap.put("codCre", createdDealer.getCodCre());
            createDealerMap.put("Error", null);
        } catch (Exception e) {
            createDealerMap.put("Status", "KO");
            createDealerMap.put("Message", "Error Creating Dealer!");
            createDealerMap.put("codCre", null);
            createDealerMap.put("Error", e.getMessage());
        }
        return createDealerMap;
    }

    @Override
    public HashMap<String, String> updateDealer(@NonNull CreModel creModel, String codCre) {
        var updateDealerMap = new HashMap<String, String>();
        creModel.setCodCre(codCre);
        try {
            if(creRepository.findById(codCre).isEmpty())
                throw new Exception("Given Dealer Id does not exist!");
            creRepository.saveAndFlush(creModel);
            updateDealerMap.put("Status", "OK");
            updateDealerMap.put("Message", "Dealer Updated Successfully!");
            updateDealerMap.put("Error", null);
        } catch (Exception e) {
            updateDealerMap.put("Status", "KO");
            updateDealerMap.put("Message", "Error Updating Dealer!");
            updateDealerMap.put("Error", e.getMessage());
        }
        return updateDealerMap;
    }

    @Override
    public HashMap<String, String> deleteDealer(String codCre) {
        var deleteDealerMap = new HashMap<String, String>();
        try {
            if(creRepository.findById(codCre).isEmpty())
                throw new Exception("Given Dealer Id does not exist!");
            creRepository.deleteById(codCre);
            deleteDealerMap.put("Status", "OK");
            deleteDealerMap.put("Message", "Dealer Deleted Successfully!");
            deleteDealerMap.put("Error", null);
        } catch (Exception e) {
            deleteDealerMap.put("Status", "KO");
            deleteDealerMap.put("Message", "Error Deleting Dealer!");
            deleteDealerMap.put("Error", e.getMessage());
        }
        return deleteDealerMap;
    }
}
