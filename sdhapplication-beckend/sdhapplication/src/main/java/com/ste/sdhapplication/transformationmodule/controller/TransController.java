package com.ste.sdhapplication.transformationmodule.controller;

import com.ste.sdhapplication.personalizationmodule.controller.PersController;
import com.ste.sdhapplication.transformationmodule.service.TransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/transformation")
public class TransController {
    @Autowired
    private TransService transService;
    Logger logger = LoggerFactory.getLogger(TransController.class);

}
