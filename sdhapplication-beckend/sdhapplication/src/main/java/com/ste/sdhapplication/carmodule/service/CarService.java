package com.ste.sdhapplication.carmodule.service;

import com.ste.sdhapplication.carmodule.model.CarModel;

import java.util.HashMap;
import java.util.List;

public interface CarService {
    List<CarModel> getAllCars();
    List<CarModel> getAllCarsByFamily(String familyId);
    CarModel getCarByVersionCode(String versionCode);
    HashMap<String, String> createCar(CarModel carModel);
    HashMap<String, String> updateCar(String versionCode, CarModel CarModel);
    HashMap<String, String> deleteCar(String versionCode);
}
