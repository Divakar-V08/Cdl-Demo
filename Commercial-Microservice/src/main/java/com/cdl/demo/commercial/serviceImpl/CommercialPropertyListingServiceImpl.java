package com.cdl.demo.commercial.serviceImpl;

import com.cdl.demo.commercial.service.CommercialPropertyListingService;
import com.cdl.demo.commercial.service.CommercialService;
import com.cdl.demo.common.models.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.apiwiz.compliance.config.ModuleScanner;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@ModuleScanner(moduleName = "Property Listing")
public class CommercialPropertyListingServiceImpl implements CommercialPropertyListingService {

    @Override
    public ResponseEntity<?> getPropertyListings() {
        return ResponseEntity.ok(CommercialServiceImpl.properties);
    }
}
