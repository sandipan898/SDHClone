package com.ste.sdhapplication.cremodule.controller;

import com.ste.sdhapplication.cremodule.service.CreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cre")
public class CreController {
    @Autowired
    private CreService creService;
}
