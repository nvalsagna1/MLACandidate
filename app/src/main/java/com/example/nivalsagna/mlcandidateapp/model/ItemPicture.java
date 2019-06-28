package com.example.nivalsagna.mlcandidateapp.model;

public class ItemPicture {

    private String secure_url;
    private String size;
    private String max_size;

    public ItemPicture(String secure_url, String size, String max_size) {
        this.secure_url = secure_url;
        this.size = size;
        this.max_size = max_size;
    }

    public String getSecure_url() {
        return secure_url;
    }

    public String getSize() {
        return size;
    }

    public String getMax_size() {
        return max_size;
    }

}
