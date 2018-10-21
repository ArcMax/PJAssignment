package com.archana.pJAssignment.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("@id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private ImageContent image;
    @SerializedName("detailedDescription")
    private DetailedDescription detailedDescription;

    public Result(String id,String name, String description, ImageContent image,DetailedDescription detailedDescription){
        this.id = id;
        this.name = name;
        this.description = description;
        this. image = image;
        this.detailedDescription = detailedDescription;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ImageContent getImage() {
        return image;
    }

    public DetailedDescription getDetailedDescription() {
        return detailedDescription;
    }
}
