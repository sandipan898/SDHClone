package com.ste.sdhapplication.parmodule.controller;

import com.ste.sdhapplication.parmodule.model.ParModel;
import com.ste.sdhapplication.parmodule.service.ParService;
import com.ste.sdhapplication.usermodule.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/parameter")
public class ParController {
    @Autowired
    private ParService parService;

    Logger logger = LoggerFactory.getLogger(ParController.class);

    @GetMapping("/")
    public List<ParModel> list() {
        logger.info("Accessing list() -> GET : api/v1/par/");
        return parService.getAllParameter();
    }

    @GetMapping("/{parId}")
    public ParModel getById(@PathVariable Long parId) {
        logger.info("Accessing getById() -> GET : api/v1/par/{parId}");
        return parService.getParameterById(parId);
    }

    @GetMapping("/by_key/{key}")
    public ParModel getByKey(@PathVariable String key) {
        logger.info("Accessing getByKey() -> GET : api/v1/par/by_key/{key}");
        return parService.getParameterByKey(key);
    }

    @GetMapping("/value_by_key/{key}")
    public String getValueByKey(@PathVariable String key) {
        logger.info("Accessing getByKey() -> GET : api/v1/par/value_by_key/{key}");
        return parService.getParameterValueByKey(key);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final ParModel parModel) {
        logger.info("Accessing create() -> POST : api/v1/par/");
        return parService.createParameter(parModel);
    }

    @PutMapping("/{parId}")
    public HashMap<String, String> update(@PathVariable Long parId, @RequestBody ParModel parModel) {
        logger.info("Accessing update() -> PUT : api/v1/par/{parId}");
        return parService.updateParameter(parModel, parId);
    }

    @DeleteMapping("/{parId}")
    public HashMap<String, String> delete(@PathVariable Long parId) {
        logger.info("Accessing delete() -> DELETE : api/v1/par/{parId}");
        return parService.deleteParameter(parId);
    }
}
