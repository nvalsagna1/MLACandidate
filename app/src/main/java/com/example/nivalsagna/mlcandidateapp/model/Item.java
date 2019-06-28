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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public Item(String id, String title, double price, String currency_id, String thumbnail) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.currency_id = currency_id;
        this.thumbnail = thumbnail;
    }


}
