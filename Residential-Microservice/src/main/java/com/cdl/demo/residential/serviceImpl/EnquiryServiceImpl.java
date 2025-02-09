package com.cdl.demo.residential.serviceImpl;

import com.cdl.demo.common.models.Enquiry;
import com.cdl.demo.residential.service.EnquiryService;
import io.apiwiz.compliance.config.ModuleScanner;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@ModuleScanner(moduleName = "Residential")
public class EnquiryServiceImpl implements EnquiryService {

    List<Enquiry> enquiries = new ArrayList<>();

    @Override
    public ResponseEntity<?> createEnquiry(Enquiry enquiry) {
        enquiry.setId(new ObjectId().toString());
        enquiries.add(enquiry);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> updateEnquiry(String id, Enquiry enquiry) {
        for (Enquiry enquiry1 : enquiries) {
            if (StringUtils.equals(enquiry1.getId(), id)) {
                enquiry1.setName(enquiry.getName());
                enquiry1.setEmail(enquiry.getEmail());
                enquiry1.setEnquiryType(enquiry.getEnquiryType());
                enquiry1.setDescription(enquiry.getDescription());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteEnquiry(String id) {
        for (int i = 0; i < enquiries.size(); i++) {
            Enquiry enquiry1 = enquiries.get(i);
            if (StringUtils.equals(enquiry1.getId(), id)) {
                enquiries.remove(i);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getEnquiry(String id) {
        for (Enquiry enquiry1 : enquiries) {
            if (StringUtils.equals(enquiry1.getId(), id)) {
                return ResponseEntity.ok(enquiry1);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> getEnquiries() {
        return ResponseEntity.ok(enquiries);
    }
}
