package com.cdl.demo.common.models;

import lombok.Data;

import java.util.List;

@Data
public class Property {
    private String id;
    private SaleType type;
    private String name;
    private String country;
    private String category;
    private String status;
    private String fullLocation;
    private List<String> imagesLinks;
    private PropertyType propertyType;
}
