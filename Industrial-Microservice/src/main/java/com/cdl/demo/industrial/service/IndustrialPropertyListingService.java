package com.cdl.demo.industrial.service;

import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/v1/industrial")
@ModuleScanner(moduleName = "Industrial Property Listing")
public interface IndustrialPropertyListingService {

    @GetMapping("/listings")
    public ResponseEntity<?> getPropertyListings();
}
