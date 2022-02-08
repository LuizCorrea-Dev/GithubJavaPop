package com.luizcorrea.github_javapop.networking.githubRepoDetails;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDetails {

    public static final String BASE_URL = "https://api.github.com/";
    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static GitHubRepoDetailsDataService getApiService() {
        return getRetrofitInstance().create(GitHubRepoDetailsDataService.class);
    }
}

