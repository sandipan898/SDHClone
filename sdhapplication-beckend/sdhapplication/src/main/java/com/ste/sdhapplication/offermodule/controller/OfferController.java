package com.ste.sdhapplication.offermodule.controller;

import com.ste.sdhapplication.offermodule.model.OfferModel;
import com.ste.sdhapplication.offermodule.service.OfferService;
import com.ste.sdhapplication.usermodule.controller.UserController;
import com.ste.sdhapplication.usermodule.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/offer")
public class OfferController {
    @Autowired
    private OfferService offerService;

    Logger logger = LoggerFactory.getLogger(OfferController.class);

    @GetMapping("/")
    public List<OfferModel> list() {
        logger.info("Accessing list() -> GET : api/v1/offer/");
        return offerService.getAllOffers();
    }

    @GetMapping("/{offerId}")
    public OfferModel getById(@PathVariable Long offerId) {
        logger.info("Accessing getById() -> GET : api/v1/offer/{offerId}");
        return offerService.getOfferById(offerId);
    }

    @GetMapping("/by_user/{userId}")
    public List<OfferModel> getByUserId(@PathVariable String userId) {
        logger.info("Accessing getByUserId() -> GET : api/v1/offer/by_user/{userId}");
        return offerService.getAllOffersByUser(userId);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final OfferModel offerModel) {
        logger.info("Accessing create() -> POST : api/v1/offer/");
        return offerService.createOffer(offerModel);
    }

    @PutMapping("/{offerId}")
    public HashMap<String, String> update(@PathVariable Long offerId, @RequestBody final OfferModel offerModel) {
        logger.info("Accessing update() -> PUT : api/v1/offer/{offerId}");
        return offerService.updateOffer(offerId, offerModel);
    }

    @DeleteMapping("/{offerId}")
    public HashMap<String, String> delete(@PathVariable Long offerId) {
        logger.info("Accessing delete() -> DELETE : api/v1/offer/{offerId}");
        return offerService.deleteOffer(offerId);
    }
}
