package com.archana.pJAssignment.model;

import com.google.gson.annotations.SerializedName;

public class ImageContent {
    @SerializedName("contentUrl")
    private String contentUrl;
    @SerializedName("url")
    private String url;

    public ImageContent(String contentUrl,String url){
        this.contentUrl = contentUrl;
        this.url = url;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
