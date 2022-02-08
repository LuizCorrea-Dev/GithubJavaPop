package com.luizcorrea.github_javapop.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.luizcorrea.github_javapop.model.repoList.GithubDBResponse;
import com.luizcorrea.github_javapop.model.repoList.Item;
import com.luizcorrea.github_javapop.repository.MainRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {

    private MainRepository mainRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository();
    }

    public LiveData<List<Item>> getAllItems() {
        return mainRepository.getMutableLiveData();
    }

}

