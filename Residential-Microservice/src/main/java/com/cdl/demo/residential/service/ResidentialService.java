package com.cdl.demo.residential.service;

import com.cdl.demo.common.models.Property;
import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/residential")
@ModuleScanner(moduleName = "Residential")
public interface ResidentialService {

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

    @GetMapping("/properties/name")
    public ResponseEntity<?> getPropertyByName(
            @PathVariable String id
    );

    @GetMapping("/properties")
    public ResponseEntity<?> getProperties();
}
