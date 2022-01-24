package com.example.pistock.model;

public class MainImageModel {
    private UrlModel urls;

    public MainImageModel(UrlModel urls) {
        this.urls = urls;
    }

    public UrlModel getUrls() {
        return urls;
    }

    public void setUrls(UrlModel urls) {
        this.urls = urls;
    }
}
