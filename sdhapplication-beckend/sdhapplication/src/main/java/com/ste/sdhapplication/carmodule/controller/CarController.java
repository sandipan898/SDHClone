package com.ste.sdhapplication.carmodule.controller;

import com.ste.sdhapplication.carmodule.model.CarModel;
import com.ste.sdhapplication.carmodule.service.CarService;
import com.ste.sdhapplication.usermodule.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/car")
public class CarController {
    @Autowired
    private CarService carService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public List<CarModel> list() {
        logger.info("Accessing list() -> GET : api/v1/car/");
        return carService.getAllCars();
    }

    @GetMapping("/{versionCode}")
    public CarModel getById(@PathVariable String versionCode) {
        logger.info("Accessing getById() -> GET : api/v1/car/{versionCode}");
        return carService.getCarByVersionCode(versionCode);
    }

    @GetMapping("/family/{familyCode}")
    public List<CarModel> getByFamilyCode(@PathVariable String familyCode) {
        logger.info("Accessing getByFamilyCode() -> GET : api/v1/car/family/{familyCode}");
        return carService.getAllCarsByFamily(familyCode);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final CarModel carModel) {
        logger.info("Accessing create() -> POST : api/v1/car/");
        return carService.createCar(carModel);
    }

    @PutMapping("/{versionCode}")
    public HashMap<String, String> update(@PathVariable String versionCode, @RequestBody final CarModel carModel) {
        logger.info("Accessing update() -> PUT : api/v1/car/{versionCode}");
        return carService.updateCar(versionCode, carModel);
    }

    @DeleteMapping("/{versionCode}")
    public HashMap<String, String> delete(@PathVariable String versionCode) {
        logger.info("Accessing delete() -> DELETE : api/v1/car/{versionCode}");
        return carService.deleteCar(versionCode);
    }
}
