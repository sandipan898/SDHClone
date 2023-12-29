package com.ste.sdhapplication.vehiclemodule.service;

import com.ste.sdhapplication.vehiclemodule.model.VersionModel;

import java.util.HashMap;
import java.util.List;

public interface VersionService {
    List<VersionModel> getAllCars();
    List<VersionModel> getAllCarsByFamily(String familyId);
    VersionModel getCarByVersionCode(String versionCode);
    HashMap<String, String> createCar(VersionModel versionModel);
    HashMap<String, String> updateCar(String versionCode, VersionModel VersionModel);
    HashMap<String, String> deleteCar(String versionCode);
}
