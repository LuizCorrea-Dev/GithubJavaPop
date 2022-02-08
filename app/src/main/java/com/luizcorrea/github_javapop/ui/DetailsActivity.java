package com.luizcorrea.github_javapop.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.luizcorrea.github_javapop.R;
import com.luizcorrea.github_javapop.databinding.ActivityDetailsBinding;
import com.luizcorrea.github_javapop.model.repoDetails.GitHubRepoDetails;
import com.luizcorrea.github_javapop.networking.githubRepoDetails.GitHubRepoDetailsDataService;
import com.luizcorrea.github_javapop.networking.githubRepoDetails.RetrofitDetails;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;

    String urlRepository = "";
    String user = "";
    String repo = "";
    private static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getExtra();
        initGetDetails();
    }

    private void initGetDetails(){

        GitHubRepoDetailsDataService api = RetrofitDetails.getApiService();
        Call<GitHubRepoDetails> call = api.RepoDetails(user,repo);
        call.enqueue(new Callback<GitHubRepoDetails>() {

            @Override
            public void onResponse(Call<GitHubRepoDetails> call, Response<GitHubRepoDetails> response) {
                ImageView context = binding.avatarDetails;
                if (response.isSuccessful()) {

                    Glide.with(context)
                            .load(response.body().getOwner()
                            .getAvatarUrl())
                            .circleCrop()
                            .into(binding.avatarDetails);

                    binding.tvReposUrl.setText(response.body().getOwner().getHtmlUrl());
                    binding.tvReposUrl.setOnClickListener(view -> {
                        String url = response.body().getOwner().getHtmlUrl();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    });

                    binding.tvFullNameLink.setText(response.body().getHtmlUrl());
                    binding.tvFullNameLink.setOnClickListener(view -> {
                        String url = response.body().getHtmlUrl();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        }
                    );

                    binding.tvUserNameDetails.setText(response.body().getOwner().getLogin());
                    binding.tvDescriptionDetails.setText(response.body().getDescription());
                    binding.tvFullName.setText(response.body().getName());
                    binding.tvForks.setText(response.body().getForks().toString());
                    binding.tvStars.setText(response.body().getStargazersCount().toString());
                    binding.tvSubscribe.setText(response.body().getSubscribersCount().toString());
                    binding.tvSize.setText(response.body().getSize().toString());

                } else {
                    showErrorMessage();
                }
            }
            @Override
            public void onFailure(Call<GitHubRepoDetails> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    private void getExtra() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("user");
            repo = extras.getString("repo");
        }
    }

    private void showErrorMessage() {
        Snackbar.make(binding.tvMensage, R.string.api_error, Snackbar.LENGTH_LONG).show();
    }

}