package com.example.pistock.model;

public class UrlModel {

    private String inge ;
   public UrlModel(String Url){
       this.inge = Url;
   }

    public String getUrl() {
        return inge;
    }

    public void setUrl(String url) {
        inge = url;
    }
}
