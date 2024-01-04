package com.ste.sdhapplication.contractmodule.service;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.offermodule.model.OfferModel;

import java.util.HashMap;
import java.util.List;

public interface ContractService {
    List<ContractModel> getAllContracts();
    List<ContractModel> getAllContractsByUser(String userId);
    ContractModel getContractById(long contractId);
    HashMap<String, String> createContract(ContractModel contractModel);
    HashMap<String, String> updateContract(long contractId, ContractModel contractModel);
    HashMap<String, String> deleteContract(long contractId);
}
