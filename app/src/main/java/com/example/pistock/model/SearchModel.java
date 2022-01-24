package com.example.pistock.model;

import java.util.ArrayList;

public class SearchModel {

    private ArrayList<MainImageModel>results;

    public SearchModel(ArrayList<MainImageModel> results) {
        this.results = results;
    }

    public ArrayList<MainImageModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<MainImageModel> results) {
        this.results = results;
    }
}
