package com.ste.sdhapplication.vehiclemodule.controller;

import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import com.ste.sdhapplication.vehiclemodule.service.VersionService;
import com.ste.sdhapplication.usermodule.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/car")
public class VersionController {
    @Autowired
    private VersionService versionService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public List<VersionModel> list() {
        logger.info("Accessing list() -> GET : api/v1/car/");
        return versionService.getAllCars();
    }

    @GetMapping("/{versionCode}")
    public VersionModel getById(@PathVariable String versionCode) {
        logger.info("Accessing getById() -> GET : api/v1/car/{versionCode}");
        return versionService.getCarByVersionCode(versionCode);
    }

    @GetMapping("/family/{familyCode}")
    public List<VersionModel> getByFamilyCode(@PathVariable String familyCode) {
        logger.info("Accessing getByFamilyCode() -> GET : api/v1/car/family/{familyCode}");
        return versionService.getAllCarsByFamily(familyCode);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final VersionModel versionModel) {
        logger.info("Accessing create() -> POST : api/v1/car/");
        return versionService.createCar(versionModel);
    }

    @PutMapping("/{versionCode}")
    public HashMap<String, String> update(@PathVariable String versionCode, @RequestBody final VersionModel versionModel) {
        logger.info("Accessing update() -> PUT : api/v1/car/{versionCode}");
        return versionService.updateCar(versionCode, versionModel);
    }

    @DeleteMapping("/{versionCode}")
    public HashMap<String, String> delete(@PathVariable String versionCode) {
        logger.info("Accessing delete() -> DELETE : api/v1/car/{versionCode}");
        return versionService.deleteCar(versionCode);
    }
}
