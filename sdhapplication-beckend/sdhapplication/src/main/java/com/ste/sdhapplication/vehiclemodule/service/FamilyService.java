package com.ste.sdhapplication.vehiclemodule.service;

import com.ste.sdhapplication.vehiclemodule.model.FamilyModel;
import com.ste.sdhapplication.vehiclemodule.model.VersionModel;

import java.util.HashMap;
import java.util.List;

public interface FamilyService {
    List<FamilyModel> getAllFamily();
    List<FamilyModel> getFamilyByUserId(String userId);
    List<FamilyModel> getFamilyByDealerId(String dealerId);
    FamilyModel getFamilyByCode(String familyCode);
    HashMap<String, String> createFamily(FamilyModel familyModel);
    HashMap<String, String> updateFamily(String familyCode, FamilyModel familyModel);
    HashMap<String, String> deleteFamily(String familyCode);
}
