package com.ste.sdhapplication.clientmodule.service;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.clientmodule.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClient() {
        return clientRepository.findAll();
    }

    public List<ClientModel> getClientByType(String type) {
        return clientRepository.findByType(type);
    }

    public ClientModel getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public HashMap<String, String> createClient(ClientModel clientModel) {
        var createClientMap = new HashMap<String, String>();
        try {
            if (clientRepository.findById(clientModel.getClientId()).isPresent())
                throw new Exception("Client with given ID already exists!");
            ClientModel createdPar = clientRepository.save(clientModel);
            createClientMap.put("Status", "OK");
            createClientMap.put("Message", "Client Created Successfully!");
            createClientMap.put("clientId", createdPar.getClientId().toString());
            createClientMap.put("Error", null);
        } catch (Exception e) {
            createClientMap.put("Status", "KO");
            createClientMap.put("Message", "Error Creating Client!");
            createClientMap.put("clientId", null);
            createClientMap.put("Error", e.getMessage());
        }
        return createClientMap;
    }
    public HashMap<String, String> updateClient(ClientModel clientModel, Long cliId) {
        var updateClientMap = new HashMap<String, String>();
        clientModel.setClientId(cliId);
        try {
            if(clientRepository.findById(cliId).isEmpty())
                throw new Exception("Given Client Id does not exist!");
            clientRepository.saveAndFlush(clientModel);
            updateClientMap.put("Status", "OK");
            updateClientMap.put("Message", "Client Updated Successfully!");
            updateClientMap.put("Error", null);
        } catch (Exception e) {
            updateClientMap.put("Status", "KO");
            updateClientMap.put("Message", "Error Updating Client!");
            updateClientMap.put("Error", e.getMessage());
        }
        return updateClientMap;
    }
    public HashMap<String, String> deleteClient(Long cliId) {
        var deleteClientMap = new HashMap<String, String>();
        try {
            if(clientRepository.findById(cliId).isEmpty())
                throw new Exception("Given Client Id does not exist!");
            clientRepository.deleteById(cliId);
            deleteClientMap.put("Status", "OK");
            deleteClientMap.put("Message", "Client Deleted Successfully!");
            deleteClientMap.put("Error", null);
        } catch (Exception e) {
            deleteClientMap.put("Status", "KO");
            deleteClientMap.put("Message", "Error Deleting Client!");
            deleteClientMap.put("Error", e.getMessage());
        }
        return deleteClientMap;
    }
}
