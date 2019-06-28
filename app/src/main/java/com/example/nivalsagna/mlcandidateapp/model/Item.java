package com.example.nivalsagna.mlcandidateapp.model;

public class Item {
    private String id;
    private String title;
    private double price;
    private String currency_id;
    private String thumbnail;

    public Item() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

}
