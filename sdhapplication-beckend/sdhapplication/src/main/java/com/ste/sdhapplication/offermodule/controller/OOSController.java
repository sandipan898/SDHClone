package com.ste.sdhapplication.offermodule.controller;

import com.ste.sdhapplication.offermodule.model.OOSModel;
import com.ste.sdhapplication.offermodule.model.OfferModel;
import com.ste.sdhapplication.offermodule.service.OOSService;
import com.ste.sdhapplication.usermodule.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/oos")
public class OOSController {
    @Autowired
    private OOSService oosService;

    Logger logger = LoggerFactory.getLogger(OOSController.class);

    @GetMapping("/by_offer/{offerId}")
    public List<OOSModel> getByOfferId(@PathVariable Long offerId) {
        logger.info("Accessing getByOfferId() -> GET : api/v1/oos/{offerId}");
        return oosService.getOOSByOffer(offerId);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final OOSModel oosModel) {
        logger.info("Accessing getByOfferId() -> POST : api/v1/oos/");
        return oosService.createOOS(oosModel);
    }
}
