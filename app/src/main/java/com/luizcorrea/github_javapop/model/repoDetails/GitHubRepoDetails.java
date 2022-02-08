package com.luizcorrea.github_javapop.model.repoDetails;

import com.google.gson.annotations.SerializedName;

public class GitHubRepoDetails {

    private String name;
    @SerializedName("full_name")
    private String fullName;
    private DetailsOwner owner;
    @SerializedName("html_url")
    private String htmlUrl;
    private String description;
    private Integer size;
    @SerializedName("stargazers_count")
    private Integer stargazersCount;
    private Integer forks;
    @SerializedName("subscribers_count")
    private Integer subscribersCount;

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

    public DetailsOwner getOwner() {
        return owner;
    }
    public void setOwner(DetailsOwner owner) {
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

    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }
    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public Integer getForks() {
        return forks;
    }
    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public Integer getSubscribersCount() {
        return subscribersCount;
    }
    public void setSubscribersCount(Integer subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

}