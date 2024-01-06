package com.ste.sdhapplication.contractmodule.service;

import com.ste.sdhapplication.contractmodule.model.ContractModel;
import com.ste.sdhapplication.contractmodule.repository.ContractRepository;
import com.ste.sdhapplication.offermodule.model.OfferModel;
import com.ste.sdhapplication.ordermodule.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<ContractModel> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public List<ContractModel> getAllContractsByUser(String userId) {
        return contractRepository.findByUser_id(userId);
    }

    @Override
    public ContractModel getContractById(long contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public List<OrderModel> getAllContractsByClient(long clientId) {
        return contractRepository.findByClient_clientId(clientId);
    }

    @Override
    public HashMap<String, String> createContract(ContractModel contractModel) {
        var createContractMap = new HashMap<String, String>();
        try {
            ContractModel createdContract = contractRepository.saveAndFlush(contractModel);
            createContractMap.put("Status", "OK");
            createContractMap.put("Message", "Contract Created Successfully!");
            createContractMap.put("ContractModel", createdContract.getId().toString());
            createContractMap.put("Error", null);
        } catch (Exception e) {
            createContractMap.put("Status", "KO");
            createContractMap.put("Message", "Error Creating Contract!");
            createContractMap.put("ContractModel", null);
            createContractMap.put("Error", e.getMessage());
        }
        return createContractMap;
    }

    @Override
    public HashMap<String, String> updateContract(long contractId, ContractModel contractModel) {
        var updateContractMap = new HashMap<String, String>();
        contractModel.setId(contractId);
        try {
            if(contractRepository.findById(contractId).isEmpty())
                throw new Exception("Given Contract Id does not exist!");
            contractRepository.saveAndFlush(contractModel);
            updateContractMap.put("Status", "OK");
            updateContractMap.put("Message", "Contract Updated Successfully!");
            updateContractMap.put("Error", null);
        } catch (Exception e) {
            updateContractMap.put("Status", "KO");
            updateContractMap.put("Message", "Error Updating Contract!");
            updateContractMap.put("Error", e.getMessage());
        }
        return updateContractMap;
    }

    @Override
    public HashMap<String, String> deleteContract(long contractId) {
        var deleteContractMap = new HashMap<String, String>();
        try {
            if(contractRepository.findById(contractId).isEmpty())
                throw new Exception("Given Contract Id does not exist!");
            contractRepository.deleteById(contractId);
            deleteContractMap.put("Status", "OK");
            deleteContractMap.put("Message", "Contract Deleted Successfully!");
            deleteContractMap.put("Error", null);
        } catch (Exception e) {
            deleteContractMap.put("Status", "KO");
            deleteContractMap.put("Message", "Error Deleting Contract!");
            deleteContractMap.put("Error", e.getMessage());
        }
        return deleteContractMap;
    }
}
