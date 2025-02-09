package com.cdl.demo.commercial.service;

import com.cdl.demo.common.models.Property;
import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/commercial")
@ModuleScanner(moduleName = "Commercial")
public interface CommercialService {

    @PostMapping("/properties")
    public ResponseEntity<?> createProperty(
            @RequestBody Property property
    );

    @PutMapping("/properties/{id}")
    public ResponseEntity<?> updateProperty(
            @PathVariable String id,
            @RequestBody Property property
    );

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<?> deleteProperty(
            @PathVariable String id
    );

    @GetMapping("/properties/{id}")
    public ResponseEntity<?> getProperty(
            @PathVariable String id
    );

    @GetMapping("/properties")
    public ResponseEntity<?> getProperties();

    @GetMapping("/listings")
    public ResponseEntity<?> getPropertyListings();
}
