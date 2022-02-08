package com.luizcorrea.github_javapop.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.luizcorrea.github_javapop.model.repoList.GithubDBResponse;
import com.luizcorrea.github_javapop.model.repoList.Item;
import com.luizcorrea.github_javapop.networking.githubRepoList.GithubDataService;
import com.luizcorrea.github_javapop.networking.githubRepoList.RetrofitGithub;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    int page = 1;
    private static MainRepository instance;

    private ArrayList<Item> items = new ArrayList<>();
    private MutableLiveData<List<Item>> mutableLiveData = new MutableLiveData<>();

    public MainRepository() {}

    public MutableLiveData<List<Item>> getMutableLiveData() {
        final GithubDataService githubDataService = RetrofitGithub.getService();

        Call<GithubDBResponse> call = githubDataService.getItemsData();
        call.enqueue(new Callback<GithubDBResponse>() {

            @Override
            public void onResponse(Call<GithubDBResponse> call, Response<GithubDBResponse> response){
                GithubDBResponse githubDBResponse = response.body();

                if (githubDBResponse != null && githubDBResponse.getGithubItems() != null) {
                    items = (ArrayList<Item>) githubDBResponse.getGithubItems();
                    mutableLiveData.setValue(items);

                } else {
                    Log.e("TAG", "response repository Error");
                }
            }

            @Override
            public void onFailure(Call<GithubDBResponse> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }
}
