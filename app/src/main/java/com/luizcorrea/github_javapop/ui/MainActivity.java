package com.luizcorrea.github_javapop.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luizcorrea.github_javapop.adapter.MainAdapter;
import com.luizcorrea.github_javapop.databinding.ActivityMainBinding;
import com.luizcorrea.github_javapop.model.repoList.Item;
import com.luizcorrea.github_javapop.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainAdapter adapter;
    private MainViewModel mainViewModel;

    String textSearch = "";
    private TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initSetup();
        //getClickToolbar();
    }


    private void initSetup() {
        RecyclerView recyclerView = binding.rvRepo;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);

        getAllItems();
    }

    private void getAllItems() {
        mainViewModel.getAllItems().observe(this, new Observer<List<Item>>() {

            @Override
            public void onChanged(@Nullable List<Item> items) {
                adapter.updateDateSet(items);

                binding.tvUsernameResult.setText(String.valueOf(items.size()+" items"));
            }
        });
    }


    private void getClickToolbar() {
        binding.toolbar.setOnClickListener(view -> {
            binding.searchBar.setVisibility(View.VISIBLE);
            searchListener();
        });

        binding.btnCloseSearchBar.setOnClickListener(view -> {
            binding.inputSearch.setText("");
            binding.searchBar.setVisibility(View.GONE);
        });

    }
    private void searchListener(){
        binding.inputSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    textSearch = binding.inputSearch.getText().toString();
                    binding.tvUsernameResult.setText(textSearch);
                }else {
                    binding.inputSearch.setText("");
                }
            }
        });
    }

}