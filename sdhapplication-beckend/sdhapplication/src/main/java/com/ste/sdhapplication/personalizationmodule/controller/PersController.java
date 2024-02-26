package com.ste.sdhapplication.personalizationmodule.controller;

import com.ste.sdhapplication.personalizationmodule.model.PersModel;
import com.ste.sdhapplication.personalizationmodule.service.PersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/personalization")
public class PersController {
    @Autowired
    private PersService persService;

    Logger logger = LoggerFactory.getLogger(PersController.class);

    @GetMapping("/")
    public List<PersModel> list() {
        logger.info("Accessing list() -> GET : api/v1/personalization/");
        return persService.getAllPersonalization();
    }

    @GetMapping("/{id}")
    public PersModel getById(@PathVariable Long id) {
        logger.info("Accessing getById() -> GET : api/v1/personalization/{id}");
        return persService.getPersonalizationById(id);
    }

    @GetMapping("/by_range")
    public List<PersModel> getByRange(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        logger.info("Accessing getByRange() -> GET : api/v1/personalization/by_range");
        return persService.getPersonalizationByRange(minPrice, maxPrice);
    }

    @GetMapping("/by_price")
    public List<PersModel> getByPrice(@RequestParam BigDecimal price) {
        logger.info("Accessing getByPrice() -> GET : api/v1/personalization/by_price");
        return persService.getPersonalizationByPrice(price);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final PersModel persModel) {
        logger.info("Accessing create() -> POST : api/v1/personalization/");
        return persService.createPersonalization(persModel);
    }

    @PutMapping("/{id}")
    public HashMap<String, String> update(@PathVariable Long id, @RequestBody PersModel persModel) {
        logger.info("Accessing update() -> PUT : api/v1/personalization/{id}");
        return persService.updatePersonalization(persModel, id);
    }

    @DeleteMapping("/{id}")
    public HashMap<String, String> delete(@PathVariable Long id) {
        logger.info("Accessing delete() -> DELETE : api/v1/personalization/{id}");
        return persService.deletePersonalization(id);
    }
}
