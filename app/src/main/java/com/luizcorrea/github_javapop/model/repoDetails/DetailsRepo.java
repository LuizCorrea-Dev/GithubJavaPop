package com.luizcorrea.github_javapop.model.repoDetails;

import java.io.Serializable;
import java.util.List;

public class DetailsRepo implements Serializable {

    private List<GitHubRepoDetails> GitHubRepoDetails = null;

    public List<GitHubRepoDetails> getItems() {
        return GitHubRepoDetails;
    }
    public void setItems(List<GitHubRepoDetails> repo) {
        this.GitHubRepoDetails = repo;
    }
}
