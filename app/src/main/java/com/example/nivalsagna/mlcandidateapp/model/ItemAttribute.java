package com.example.nivalsagna.mlcandidateapp.model;

public class ItemAttribute {
    private String name;
    private String value_name;

    public ItemAttribute(String name, String value_name) {
        this.name = name;
        this.value_name = value_name;
    }

    public String getName() {
        return name;
    }

    public String getValue_name() {
        return value_name;
    }
}
