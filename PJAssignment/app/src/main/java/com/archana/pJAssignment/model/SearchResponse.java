package com.archana.pJAssignment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SearchResponse {

    @SerializedName("itemListElement")
    private List<SearchType> itemListElement;

    public SearchResponse(List<SearchType> itemListElement){
        this.itemListElement = itemListElement;
    }

    public List<SearchType> getResults() {
        return itemListElement;
    }
}

