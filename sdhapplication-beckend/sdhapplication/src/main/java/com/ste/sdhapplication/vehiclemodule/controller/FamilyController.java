package com.ste.sdhapplication.vehiclemodule.controller;

import com.ste.sdhapplication.usermodule.controller.UserController;
import com.ste.sdhapplication.vehiclemodule.model.FamilyModel;
import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import com.ste.sdhapplication.vehiclemodule.service.FamilyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/family")
public class FamilyController {
    @Autowired
    private FamilyServiceImpl familyServiceImpl;

    Logger logger = LoggerFactory.getLogger(FamilyController.class);

    @GetMapping("/")
    public List<FamilyModel> list() {
        logger.info("Accessing list() -> GET : api/v1/family/");
        return familyServiceImpl.getAllFamily();
    }

    @GetMapping("/{familyCode}")
    public FamilyModel getById(@PathVariable String familyCode) {
        logger.info("Accessing getById() -> GET : api/v1/family/{familyCode}");
        return familyServiceImpl.getFamilyByCode(familyCode);
    }

    @GetMapping("/by_dealer/{dealerId}")
    public List<FamilyModel> getByDealerId(@PathVariable String dealerId) {
        logger.info("Accessing getByFamilyCode() -> GET : api/v1/car/family/by_dealer/{dealerId}");
        return familyServiceImpl.getFamilyByDealerId(dealerId);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final FamilyModel familyModel) {
        logger.info("Accessing create() -> POST : api/v1/family/");
        return familyServiceImpl.createFamily(familyModel);
    }

    @PutMapping("/{familyCode}")
    public HashMap<String, String> update(@PathVariable String familyCode, @RequestBody final FamilyModel familyModel) {
        logger.info("Accessing update() -> PUT : api/v1/family/{familyCode}");
        return familyServiceImpl.updateFamily(familyCode, familyModel);
    }

    @DeleteMapping("/{familyCode}")
    public HashMap<String, String> delete(@PathVariable String familyCode) {
        logger.info("Accessing delete() -> DELETE : api/v1/family/{familyCode}");
        return familyServiceImpl.deleteFamily(familyCode);
    }
}
