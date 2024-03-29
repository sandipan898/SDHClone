package com.ste.sdhapplication.clientmodule.controller;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.clientmodule.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/")
    public List<ClientModel> list() {
        logger.info("Accessing list() -> GET : api/v1/client/");
        return clientService.getAllClient();
    }

    @GetMapping("/{clientId}")
    public ClientModel getById(@PathVariable Long clientId) {
        logger.info("Accessing getById() -> GET : api/v1/client/{clientId}");
        return clientService.getClientById(clientId);
    }

    @GetMapping("/by_type/{type}")
    public List<ClientModel> getByType(@PathVariable String type) {
        logger.info("Accessing getByType() -> GET : api/v1/client/by_type/{type}");
        return clientService.getClientByType(type);
    }

    @GetMapping("/by_cre/{codCre}")
    public List<ClientModel> getByCre(@PathVariable String codCre) {
        logger.info("Accessing getByCre() -> GET : api/v1/client/by_cre/{codCre}");
        return clientService.getClientsByCre(codCre);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final ClientModel clientModel) {
        logger.info("Accessing create() -> POST : api/v1/client/");
        return clientService.createClient(clientModel);
    }

    @PutMapping("/{clientId}")
    public HashMap<String, String> update(@PathVariable Long clientId, @RequestBody ClientModel clientModel) {
        logger.info("Accessing update() -> PUT : api/v1/client/{clientId}");
        return clientService.updateClient(clientModel, clientId);
    }

    @DeleteMapping("/{clientId}")
    public HashMap<String, String> delete(@PathVariable Long clientId) {
        logger.info("Accessing delete() -> DELETE : api/v1/client/{clientId}");
        return clientService.deleteClient(clientId);
    }
}
