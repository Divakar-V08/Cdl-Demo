package com.cdl.demo.residential.serviceImpl;

import com.cdl.demo.common.models.Property;
import com.cdl.demo.residential.service.ResidentialService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.apiwiz.compliance.config.ModuleScanner;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@ModuleScanner(moduleName = "Residential")
public class ResidentialServiceImpl implements ResidentialService {

    public static List<Property> properties = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        try {
            InputStream inputStream = ResourceReader.class.getClassLoader().getResourceAsStream("properties.json");
            properties = new ObjectMapper().readValue(inputStream, new TypeReference<List<Property>>() {
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ResponseEntity<?> createProperty(Property property) {
        property.setId(new ObjectId().toString());
        properties.add(property);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> updateProperty(String id, Property property) {
        for (Property property1 : properties) {
            if (StringUtils.equals(property1.getId(), id)) {
                property1.setName(property.getName());
                property1.setPropertyType(property.getPropertyType());
                property1.setCategory(property.getCategory());
                property1.setCountry(property.getCountry());
                property1.setImagesLinks(property.getImagesLinks());
                property1.setStatus(property.getStatus());
                property1.setType(property.getType());
                property1.setFullLocation(property.getFullLocation());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteProperty(String id) {
        for (int i = 0; i < properties.size(); i++) {
            Property property1 = properties.get(i);
            if (StringUtils.equals(property1.getId(), id)) {
                properties.remove(i);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getProperty(String id) {
        for (Property property1 : properties) {
            if (StringUtils.equals(property1.getId(), id)) {
                return ResponseEntity.ok(property1);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> getPropertyByName(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getProperties() {
        return ResponseEntity.ok(properties);
    }
}
