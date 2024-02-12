package com.ste.sdhapplication.cremodule.controller;

import com.ste.sdhapplication.cremodule.model.CreModel;
import com.ste.sdhapplication.cremodule.service.CreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/cre")
public class CreController {
    @Autowired
    private CreService creService;

    Logger logger = LoggerFactory.getLogger(CreController.class);

    @GetMapping("/")
    public List<CreModel> list() {
        logger.info("Accessing list() -> GET : api/v1/cre/");
        return creService.getAllDealers();
    }

    @GetMapping("/{codCre}")
    public CreModel getById(@PathVariable String codCre) {
        logger.info("Accessing getById() -> GET : api/v1/cre/{codCre}");
        return creService.getDealerById(codCre);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final CreModel creModel) {
        logger.info("Accessing create() -> POST : api/v1/cre/");
        return creService.createDealer(creModel);
    }

    @PutMapping("/{codCre}")
    public HashMap<String, String> update(@PathVariable String codCre, @RequestBody CreModel creModel) {
        logger.info("Accessing update() -> PUT : api/v1/cre/{codCre}");
        return creService.updateDealer(creModel, codCre);
    }

    @DeleteMapping("/{codCre}")
    public HashMap<String, String> delete(@PathVariable String codCre) {
        logger.info("Accessing delete() -> DELETE : api/v1/cre/{codCre}");
        return creService.deleteDealer(codCre);
    }
}
