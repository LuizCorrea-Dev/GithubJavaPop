package com.luizcorrea.github_javapop.networking.githubRepoDetails;

import com.luizcorrea.github_javapop.model.repoDetails.GitHubRepoDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubRepoDetailsDataService {
    public static final String BASE_URL = "https://api.github.com/";

    @GET("repos/{user}/{repo}")
    Call<GitHubRepoDetails> RepoDetails(
            @Path("user") String user,
            @Path("repo") String repo
    );
}