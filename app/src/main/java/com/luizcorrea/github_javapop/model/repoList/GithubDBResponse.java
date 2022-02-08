package com.luizcorrea.github_javapop.model.repoList;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class GithubDBResponse implements Serializable {

    @SerializedName("total_count")
    private Integer totalCount;

    @SerializedName("incomplete_results")
    private Boolean incompleteResults;

    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }
    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    private List<Item> items = null;

    public List<Item> getGithubItems() {
        return items;
    }
    public void setGithubItems(List<Item> items) {
        this.items = items;
    }


}