package com.cdl.demo.residential.service;

import com.cdl.demo.common.models.Enquiry;
import io.apiwiz.compliance.config.ModuleScanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/residential")
@ModuleScanner(moduleName = "Residential")
public interface EnquiryService {

    @PostMapping("/enquiries")
    public ResponseEntity<?> createEnquiry(
            @RequestBody Enquiry Enquiry
    );

    @PutMapping("/enquiries/{id}")
    public ResponseEntity<?> updateEnquiry(
            @PathVariable String id,
            @RequestBody Enquiry Enquiry
    );

    @DeleteMapping("/enquiries/{id}")
    public ResponseEntity<?> deleteEnquiry(
            @PathVariable String id
    );

    @GetMapping("/enquiries/{id}")
    public ResponseEntity<?> getEnquiry(
            @PathVariable String id
    );

    @GetMapping("/enquiries")
    public ResponseEntity<?> getEnquiries();
}
