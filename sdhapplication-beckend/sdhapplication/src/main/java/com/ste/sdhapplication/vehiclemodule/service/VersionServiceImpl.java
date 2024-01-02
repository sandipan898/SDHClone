package com.ste.sdhapplication.vehiclemodule.service;

import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import com.ste.sdhapplication.vehiclemodule.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VersionServiceImpl implements VersionService {
    @Autowired
    private VersionRepository versionRepository;

    @Override
    public List<VersionModel> getAllCars() {
        return versionRepository.findAll();
    }

    @Override
    public List<VersionModel> getAllCarsByFamily(String familyId) {
        return versionRepository.findByFamily_code(familyId);
    }

    @Override
    public VersionModel getCarByVersionCode(String versionCode) {
        return versionRepository.findById(versionCode).orElse(new VersionModel());
    }

    @Override
    public HashMap<String, String> createCar(VersionModel versionModel) {
        var createCarMap = new HashMap<String, String>();
        try {
            if(versionRepository.findById(versionModel.getCode()).isPresent())
                throw new Exception("Car with the given Version Code already exists!");
            VersionModel createdCar = versionRepository.saveAndFlush(versionModel);
            createCarMap.put("Status", "OK");
            createCarMap.put("Message", "Car Created Successfully!");
            createCarMap.put("VersionCode", createdCar.getCode());
            createCarMap.put("Error", null);
        } catch (Exception e) {
            createCarMap.put("Status", "KO");
            createCarMap.put("Message", "Error Creating Car!");
            createCarMap.put("versionCode", null);
            createCarMap.put("Error", e.getMessage());
        }
        return createCarMap;
    }

    @Override
    public HashMap<String, String> updateCar(String versionCode, VersionModel versionModel) {
        var updateCarMap = new HashMap<String, String>();
        versionModel.setCode(versionCode);
        try {
            if(versionRepository.findById(versionCode).isEmpty())
                throw new Exception("Given Version Code does not exist!");
            VersionModel createdCar = versionRepository.saveAndFlush(versionModel);
            updateCarMap.put("Status", "OK");
            updateCarMap.put("Message", "Car Updated Successfully!");
            updateCarMap.put("versionCode", createdCar.getCode());
            updateCarMap.put("Error", null);
        } catch (Exception e) {
            updateCarMap.put("Status", "KO");
            updateCarMap.put("Message", "Error Updating Car!");
            updateCarMap.put("versionCode", null);
            updateCarMap.put("Error", e.getMessage());
        }
        return updateCarMap;
    }

    @Override
    public HashMap<String, String> deleteCar(String versionCode) {
        var deleteCarMap = new HashMap<String, String>();
        try {
            if(versionRepository.findById(versionCode).isEmpty())
                throw new Exception("Given Version Code does not exist!");
            versionRepository.deleteById(versionCode);
            deleteCarMap.put("Status", "OK");
            deleteCarMap.put("Message", "Car Deleted Successfully!");
            deleteCarMap.put("Error", null);
        } catch (Exception e) {
            deleteCarMap.put("Status", "KO");
            deleteCarMap.put("Message", "Error Deleting Car!");
            deleteCarMap.put("Error", e.getMessage());
        }
        return deleteCarMap;
    }
}
