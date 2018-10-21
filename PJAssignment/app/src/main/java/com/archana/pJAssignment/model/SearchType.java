package com.archana.pJAssignment.model;

import com.google.gson.annotations.SerializedName;


public class SearchType {
    @SerializedName("@type")
    private String type;
    @SerializedName("result")
    private Result result;

    public SearchType(String type, Result result) {
        this.type = type;
        this.result = result;
    }

    public String getType() {
        return type;
    }
    public Result getResult() {
        return result;
    }
}
