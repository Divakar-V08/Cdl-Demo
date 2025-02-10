package com.cdl.demo.residential.service;

import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/v1/residential")
//@ModuleScanner(moduleName = "Residential Property Listing")
public interface ResidentialPropertyListingService {

    @GetMapping("/listings")
    public ResponseEntity<?> getPropertyListings();
}
