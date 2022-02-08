package com.luizcorrea.github_javapop.model.repoList;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    @SerializedName("full_name")
    private String fullName;
    private Owner owner;
    @SerializedName("html_url")
    private String htmlUrl;
    private String description;
    @SerializedName("stargazers_count")
    private Integer stargazersCount;
    @SerializedName("forks_count")
    private Integer forksCount;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }
    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public Integer getForksCount() {
        return forksCount;
    }
    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }
}

