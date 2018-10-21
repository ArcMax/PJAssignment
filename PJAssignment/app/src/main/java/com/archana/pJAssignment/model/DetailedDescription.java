package com.archana.pJAssignment.model;

public class DetailedDescription {

    private String articleBody;
    private String license;
    private String url;

    public DetailedDescription(String articleBody,String license,String url){
        this.articleBody = articleBody;
        this.license = license;
        this.url = url;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
