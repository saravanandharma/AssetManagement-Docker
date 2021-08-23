package com.saravanan.assetmgmt.license.service;

import com.saravanan.assetmgmt.AssetMgmtRepository;
import com.saravanan.assetmgmt.license.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LicenseService {

    @Autowired
    private final AssetMgmtRepository assetMgmtRepository;

    @Autowired
    public LicenseService(AssetMgmtRepository assetMgmtRepository){
        this.assetMgmtRepository = assetMgmtRepository;
    }

    public License getLicense( String licenseId, String orgonizationId){
        License license = new License();
        license.setId(new Random().nextLong());
        license.setLicenseType(licenseId);
        license.setOrgonizationId(orgonizationId);
        license.setDescription("Software product");
        license.setProductName("Shakthi Dharma Software");
        license.setLicenseType("full");

        return license;
    }

    public String createLicense(License license, String orgonizationId){
        String responseMessage = null;
        if(license != null){
            license.setOrgonizationId(orgonizationId);
            assetMgmtRepository.save(license);
            responseMessage = String.format(" This is the POST and the object is: %", license.toString());
        }

        return responseMessage;
    }

    public String updateLicense(License license, String orgonizationId){
        String responseMessage = null;

        if(license != null){
            license.setOrgonizationId(orgonizationId);
            //License lic = assetMgmtRepository.findByOrgonizationId(orgonizationId);
            assetMgmtRepository.save ( license );
            responseMessage = String.format(" This is the PUT and the response is: %", license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String orgonizationId){
        String responseMessage = String.format(" This is DELETE with id %s for the orgonization %s", licenseId, orgonizationId);

        return responseMessage;
    }
}
