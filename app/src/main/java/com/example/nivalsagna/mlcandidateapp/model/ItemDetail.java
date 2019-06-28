package com.example.nivalsagna.mlcandidateapp.model;

import java.util.List;

public class ItemDetail {
    private String id;
    private String title;
    private Double price;
    private String currency_id;
    private int available_quantity;
    private int sold_quantity;
    private String condition;
    private List<ItemPicture> pictures;
    private Boolean accepts_mercadopago;
    private List<ItemAttribute> attributes;

    public ItemDetail(String id, String title, Double price, String currency_id, int available_quantity, int sold_quantity, String condition, List<ItemPicture> pictures, Boolean accepts_mercadopago, List<ItemAttribute> attributes) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.currency_id = currency_id;
        this.available_quantity = available_quantity;
        this.sold_quantity = sold_quantity;
        this.condition = condition;
        this.pictures = pictures;
        this.accepts_mercadopago = accepts_mercadopago;
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }

    public String getCondition() {
        return condition;
    }

    public List<ItemPicture> getPictures() {
        return pictures;
    }

    public Boolean getAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public List<ItemAttribute> getAttributes() {
        return attributes;
    }

}
