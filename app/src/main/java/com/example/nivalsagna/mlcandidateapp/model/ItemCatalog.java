package com.example.nivalsagna.mlcandidateapp.model;

import java.util.List;

public class ItemCatalog {
    private List<Item> results;

    public ItemCatalog(List<Item> results) {
        this.results = results;
    }

    public List<Item> getResults() {
        return results;
    }
}
