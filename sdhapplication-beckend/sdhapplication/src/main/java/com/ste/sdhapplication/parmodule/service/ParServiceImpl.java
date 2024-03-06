package com.ste.sdhapplication.parmodule.service;

import com.ste.sdhapplication.parmodule.model.ParModel;
import com.ste.sdhapplication.parmodule.repository.ParRepository;
import com.ste.sdhapplication.usermodule.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ParServiceImpl implements ParService {
    @Autowired
    private ParRepository parRepository;

    public List<ParModel> getAllParameter() {
        return parRepository.findAll();
    }

    public ParModel getParameterById(Long id) {
        return parRepository.findById(id).orElse(null);
    }

    public ParModel getParameterByKey(String key) {
        return parRepository.findByKey(key).orElse(null);
    }

    public String getParameterValueByKey(String key) {
        return parRepository.findValueByKey(key);
    }

    public HashMap<String, String> createParameter(ParModel parModel) {
        var createParMap = new HashMap<String, String>();
        try {
            if (parRepository.findById(parModel.getId()).isPresent())
                throw new Exception("Parameter with given ID already exists!");
            if (parRepository.findByKey(parModel.getKey()).isPresent())
                throw new Exception("Parameter with given Key already exists!");
            ParModel createdPar = parRepository.save(parModel);
            createParMap.put("Status", "OK");
            createParMap.put("Message", "Parameter Created Successfully!");
            createParMap.put("id", createdPar.getId().toString());
            createParMap.put("Error", null);
        } catch (Exception e) {
            createParMap.put("Status", "KO");
            createParMap.put("Message", "Error Creating Parameter!");
            createParMap.put("id", null);
            createParMap.put("Error", e.getMessage());
        }
        return createParMap;
    }

    public HashMap<String, String> updateParameter(ParModel parModel, Long id) {
        var updateParMap = new HashMap<String, String>();
        parModel.setId(id);
        try {
            if(parRepository.findById(id).isEmpty())
                throw new Exception("Given Parameter Id does not exist!");
            parRepository.saveAndFlush(parModel);
            updateParMap.put("Status", "OK");
            updateParMap.put("Message", "Parameter Updated Successfully!");
            updateParMap.put("Error", null);
        } catch (Exception e) {
            updateParMap.put("Status", "KO");
            updateParMap.put("Message", "Error Updating Parameter!");
            updateParMap.put("Error", e.getMessage());
        }
        return updateParMap;
    }

    public HashMap<String, String> deleteParameter(Long id) {
        var deleteParMap = new HashMap<String, String>();
        try {
            if(parRepository.findById(id).isEmpty())
                throw new Exception("Given Parameter Id does not exist!");
            parRepository.deleteById(id);
            deleteParMap.put("Status", "OK");
            deleteParMap.put("Message", "Parameter Deleted Successfully!");
            deleteParMap.put("Error", null);
        } catch (Exception e) {
            deleteParMap.put("Status", "KO");
            deleteParMap.put("Message", "Error Deleting Parameter!");
            deleteParMap.put("Error", e.getMessage());
        }
        return deleteParMap;
    }
}
