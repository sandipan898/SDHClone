package com.ste.sdhapplication.carmodule.service;

import com.ste.sdhapplication.carmodule.model.CarModel;
import com.ste.sdhapplication.carmodule.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarModel> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<CarModel> getAllCarsByFamily(String familyId) {
        return carRepository.findByFamily(familyId);
    }

    @Override
    public CarModel getCarByVersionCode(String versionCode) {
        return carRepository.findById(versionCode).orElse(new CarModel());
    }

    @Override
    public HashMap<String, String> createCar(CarModel carModel) {
        var createCarMap = new HashMap<String, String>();
        try {
            if(carRepository.findById(carModel.getVersionCode()).isEmpty())
                throw new Exception("Car with the given Version Code already exists!");
            CarModel createdCar = carRepository.saveAndFlush(carModel);
            createCarMap.put("Status", "OK");
            createCarMap.put("Message", "Car Created Successfully!");
            createCarMap.put("VersionCode", createdCar.getVersionCode());
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
    public HashMap<String, String> updateCar(String versionCode, CarModel carModel) {
        var updateCarMap = new HashMap<String, String>();
        carModel.setVersionCode(versionCode);
        try {
            if(carRepository.findById(versionCode).isEmpty())
                throw new Exception("Given Version Code does not exist!");
            CarModel createdCar = carRepository.saveAndFlush(carModel);
            updateCarMap.put("Status", "OK");
            updateCarMap.put("Message", "Car Updated Successfully!");
            updateCarMap.put("versionCode", createdCar.getVersionCode());
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
            if(carRepository.findById(versionCode).isEmpty())
                throw new Exception("Given Version Code does not exist!");
            carRepository.deleteById(versionCode);
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
