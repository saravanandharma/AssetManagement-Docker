package com.saravanan.assetmgmt.license.controller;

import com.saravanan.assetmgmt.license.model.License;
import com.saravanan.assetmgmt.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "v1/org/{orgonizationId}/lic")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("orgonizationId") String orgonizationId,
                                              @PathVariable("licenseId") String licenseId){

        License license = licenseService.getLicense(licenseId, orgonizationId);

        license.add(linkTo(methodOn(LicenseController.class)
                .getLicense ( orgonizationId, license.getLicenseId () ))
                .withSelfRel ());
        return ResponseEntity.ok(license);
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable("orgonizationId") String orgonizationId,
                                                @RequestBody License request){
        return ResponseEntity.ok(licenseService.createLicense(request, orgonizationId));
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable("orgonizationId") String orgonizationId,
                                                @RequestBody License request){
        return ResponseEntity.ok(licenseService.updateLicense(request, orgonizationId));

    }

    @DeleteMapping(value = "{/licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("orgonizationId") String orgonizationId,
                                                @PathVariable("licenseId") String licenseId){
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, orgonizationId));
    }
}
