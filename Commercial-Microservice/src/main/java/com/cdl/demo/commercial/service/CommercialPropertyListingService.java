package com.cdl.demo.commercial.service;

import com.cdl.demo.common.models.Property;
import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/commercial")
@ModuleScanner(moduleName = "Commercial Property Listing")
public interface CommercialPropertyListingService {

    @GetMapping("/listings")
    public ResponseEntity<?> getPropertyListings();
}
