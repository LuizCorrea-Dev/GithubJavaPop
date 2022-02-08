package com.luizcorrea.github_javapop.networking.githubRepoList;

import com.luizcorrea.github_javapop.model.repoList.GithubDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubDataService {
    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    Call<GithubDBResponse> getItemsData();
}

