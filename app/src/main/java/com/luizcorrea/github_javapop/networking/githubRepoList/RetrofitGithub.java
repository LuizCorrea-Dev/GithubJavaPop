package com.luizcorrea.github_javapop.networking.githubRepoList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGithub {

    private static Retrofit retrofit;
    public static String BASE_URL = "https://api.github.com/";

    public static GithubDataService getService() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GithubDataService.class);
    }
}
