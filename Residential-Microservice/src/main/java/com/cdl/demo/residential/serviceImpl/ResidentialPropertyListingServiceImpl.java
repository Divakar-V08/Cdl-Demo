package com.cdl.demo.residential.serviceImpl;

import com.cdl.demo.residential.service.ResidentialPropertyListingService;
import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
//@ModuleScanner(moduleName = "Residential Property Listing")
public class ResidentialPropertyListingServiceImpl implements ResidentialPropertyListingService {

    @Override
    public ResponseEntity<?> getPropertyListings() {

        return ResponseEntity.ok(ResidentialServiceImpl.properties);
    }
}
