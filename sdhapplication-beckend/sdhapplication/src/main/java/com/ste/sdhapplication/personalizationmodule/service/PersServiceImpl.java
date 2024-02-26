package com.ste.sdhapplication.personalizationmodule.service;

import com.ste.sdhapplication.personalizationmodule.model.PersModel;
import com.ste.sdhapplication.personalizationmodule.repository.PersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class PersServiceImpl implements PersService {

    @Autowired
    private PersRepository persRepository;

    @Override
    public List<PersModel> getAllPersonalization() {
        return persRepository.findAll();
    }

    @Override
    public PersModel getPersonalizationById(long id) {
        return persRepository.findById(id).orElse(null);
    }

    @Override
    public List<PersModel> getPersonalizationByRange(BigDecimal minVal, BigDecimal maxVal) {
        return persRepository.findByMinPriceAndMaxPrice(minVal, maxVal);
    }

    @Override
    public List<PersModel> getPersonalizationByPrice(BigDecimal price) {
        return persRepository.findByMaxPriceLessThanEqualAndMinPriceGreaterThanEqual(price, price);
    }

    @Override
    public HashMap<String, String> createPersonalization(PersModel persModel) {
        var createPersMap = new HashMap<String, String>();
        try {
            if (persRepository.findById(persModel.getId()).isPresent())
                throw new Exception("Personalization with given ID already exists!");
            if (persRepository.findByMinPriceAndMaxPrice(persModel.getMinPrice(), persModel.getMaxPrice()).size() > 0)
                throw new Exception("Personalization with given range already exists!");
            PersModel createdPers = persRepository.save(persModel);
            createPersMap.put("Status", "OK");
            createPersMap.put("Message", "Personalization Created Successfully!");
            createPersMap.put("Id", createdPers.getId().toString());
            createPersMap.put("Error", null);
        } catch (Exception e) {
            createPersMap.put("Status", "KO");
            createPersMap.put("Message", "Error Creating Personalization!");
            createPersMap.put("Id", null);
            createPersMap.put("Error", e.getMessage());
        }
        return createPersMap;
    }

    @Override
    public HashMap<String, String> updatePersonalization(PersModel persModel, long id) {
        var updatePersMap = new HashMap<String, String>();
        persModel.setId(id);
        try {
            if(persRepository.findById(id).isEmpty())
                throw new Exception("Given Personalization Id does not exist!");
            if (persRepository.findByMinPriceAndMaxPrice(persModel.getMinPrice(), persModel.getMaxPrice()).size() > 0)
                throw new Exception("Personalization with given range already exists!");
            persRepository.saveAndFlush(persModel);
            updatePersMap.put("Status", "OK");
            updatePersMap.put("Message", "Personalization Updated Successfully!");
            updatePersMap.put("Error", null);
        } catch (Exception e) {
            updatePersMap.put("Status", "KO");
            updatePersMap.put("Message", "Error Updating Parameter!");
            updatePersMap.put("Error", e.getMessage());
        }
        return updatePersMap;
    }

    @Override
    public HashMap<String, String> deletePersonalization(long id) {
        var deletePersMap = new HashMap<String, String>();
        try {
            if(persRepository.findById(id).isEmpty())
                throw new Exception("Given Personalization Id does not exist!");
            persRepository.deleteById(id);
            deletePersMap.put("Status", "OK");
            deletePersMap.put("Message", "Personalization Deleted Successfully!");
            deletePersMap.put("Error", null);
        } catch (Exception e) {
            deletePersMap.put("Status", "KO");
            deletePersMap.put("Message", "Error Deleting Personalization!");
            deletePersMap.put("Error", e.getMessage());
        }
        return deletePersMap;
    }
}
