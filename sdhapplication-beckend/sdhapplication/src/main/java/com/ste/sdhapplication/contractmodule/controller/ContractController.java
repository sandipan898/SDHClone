package com.ste.sdhapplication.contractmodule.controller;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.contractmodule.service.ContractService;
import com.ste.sdhapplication.offermodule.controller.OfferController;
import com.ste.sdhapplication.ordermodule.model.OrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    Logger logger = LoggerFactory.getLogger(ContractService.class);

    @GetMapping("/")
    public List<ContractModel> list() {
        logger.info("Accessing list() -> GET : api/v1/contract/");
        return contractService.getAllContracts();
    }

    @GetMapping("/{contractId}")
    public ContractModel getById(@PathVariable Long contractId) {
        logger.info("Accessing getById() -> GET : api/v1/contract/{contractId}");
        return contractService.getContractById(contractId);
    }

    @GetMapping("/by_user/{userId}")
    public List<ContractModel> getByUserId(@PathVariable String userId) {
        logger.info("Accessing getByUserId() -> GET : api/v1/contract/by_user/{userId}");
        return contractService.getAllContractsByUser(userId);
    }

    @GetMapping("/by_client/{clientId}")
    public List<OrderModel> getByClientId(@PathVariable long clientId) {
        logger.info("Accessing getByClientId() -> GET : api/v1/contract/by_client/{clientId}");
        return contractService.getAllContractsByClient(clientId);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final ContractModel contractModel) {
        logger.info("Accessing create() -> POST : api/v1/contract/");
        return contractService.createContract(contractModel);
    }

    @PutMapping("/{contractId}")
    public HashMap<String, String> update(@PathVariable Long contractId, @RequestBody final ContractModel contractModel) {
        logger.info("Accessing update() -> PUT : api/v1/contract/{contractId}");
        return contractService.updateContract(contractId, contractModel);
    }

    @DeleteMapping("/{contractId}")
    public HashMap<String, String> delete(@PathVariable Long contractId) {
        logger.info("Accessing delete() -> DELETE : api/v1/contract/{contractId}");
        return contractService.deleteContract(contractId);
    }
}
