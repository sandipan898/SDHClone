package com.ste.sdhapplication.vehiclemodule.service;

import com.ste.sdhapplication.vehiclemodule.model.FamilyModel;
import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import com.ste.sdhapplication.vehiclemodule.repository.FamilyRepository;
import com.ste.sdhapplication.vehiclemodule.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public List<FamilyModel> getAllFamily() {
        return familyRepository.findAll();
    }

    @Override
    public List<FamilyModel> getFamilyByUserId(String userId) {
        return familyRepository.findByUser_id(userId);
    }

    @Override
    public List<FamilyModel> getFamilyByDealerId(String dealerId) {
        return familyRepository.findByCre_codCre(dealerId);
    }

    @Override
    public FamilyModel getFamilyByCode(String versionCode) {
        return familyRepository.findById(versionCode).orElse(new FamilyModel());
    }

    @Override
    public HashMap<String, String> createFamily(FamilyModel familyModel) {
        var createFamilyMap = new HashMap<String, String>();
        try {
            if(familyRepository.findById(familyModel.getCode()).isPresent())
                throw new Exception("Car with the given Version Code already exists!");
            FamilyModel createdFamily = familyRepository.saveAndFlush(familyModel);
            createFamilyMap.put("Status", "OK");
            createFamilyMap.put("Message", "Family Created Successfully!");
            createFamilyMap.put("FamilyCode", createdFamily.getCode());
            createFamilyMap.put("Error", null);
        } catch (Exception e) {
            createFamilyMap.put("Status", "KO");
            createFamilyMap.put("Message", "Error Creating Family!");
            createFamilyMap.put("FamilyCode", null);
            createFamilyMap.put("Error", e.getMessage());
        }
        return createFamilyMap;
    }

    @Override
    public HashMap<String, String> updateFamily(String familyCode, FamilyModel familyModel) {
        var updateFamilyMap = new HashMap<String, String>();
        familyModel.setCode(familyCode);
        try {
            if(familyRepository.findById(familyCode).isEmpty())
                throw new Exception("Given Family Code does not exist!");
            FamilyModel createdFamily = familyRepository.saveAndFlush(familyModel);
            updateFamilyMap.put("Status", "OK");
            updateFamilyMap.put("Message", "Family Updated Successfully!");
            updateFamilyMap.put("Error", null);
        } catch (Exception e) {
            updateFamilyMap.put("Status", "KO");
            updateFamilyMap.put("Message", "Error Updating Family!");
            updateFamilyMap.put("Error", e.getMessage());
        }
        return updateFamilyMap;
    }

    @Override
    public HashMap<String, String> deleteFamily(String familyCode) {
        var deleteFamilyMap = new HashMap<String, String>();
        try {
            if(familyRepository.findById(familyCode).isEmpty())
                throw new Exception("Given Family Code does not exist!");
            familyRepository.deleteById(familyCode);
            deleteFamilyMap.put("Status", "OK");
            deleteFamilyMap.put("Message", "Family Deleted Successfully!");
            deleteFamilyMap.put("Error", null);
        } catch (Exception e) {
            deleteFamilyMap.put("Status", "KO");
            deleteFamilyMap.put("Message", "Error Deleting Family!");
            deleteFamilyMap.put("Error", e.getMessage());
        }
        return deleteFamilyMap;
    }
}
