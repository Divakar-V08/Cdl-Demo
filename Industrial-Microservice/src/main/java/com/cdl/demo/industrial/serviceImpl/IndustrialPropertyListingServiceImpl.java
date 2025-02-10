package com.cdl.demo.industrial.serviceImpl;

import com.cdl.demo.industrial.service.IndustrialPropertyListingService;
import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@ModuleScanner(moduleName = "Industrial Property Listing")
public class IndustrialPropertyListingServiceImpl implements IndustrialPropertyListingService {

    @Override
    public ResponseEntity<?> getPropertyListings() {
        return ResponseEntity.ok(IndustrialServiceImpl.properties);
    }
}
