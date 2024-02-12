package com.ste.sdhapplication.clientmodule.service;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.parmodule.model.ParModel;

import java.util.HashMap;
import java.util.List;

public interface ClientService {
    List<ClientModel> getAllClient();
    List<ClientModel> getClientByType(String type);
    ClientModel getClientById(Long clientId);
    List<ClientModel> getClientsByCre(String codCre);
    HashMap<String, String> createClient(ClientModel clientModel);
    HashMap<String, String> updateClient(ClientModel clientModel, Long cliId);
    HashMap<String, String> deleteClient(Long cliId);
}
