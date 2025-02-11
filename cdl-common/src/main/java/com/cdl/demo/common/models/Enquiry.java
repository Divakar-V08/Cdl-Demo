package com.cdl.demo.common.models;

import lombok.Data;

@Data
public class Enquiry {
    private String id;
    private String name;
    private String email;
    private String description;
    private PropertyType enquiryType;
}
