package com.luizcorrea.github_javapop.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.luizcorrea.github_javapop.databinding.RowItemActivityBinding;
import com.luizcorrea.github_javapop.model.repoList.Item;
import com.luizcorrea.github_javapop.ui.DetailsActivity;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public String urlRepository;
    String user = "";
    String repo = "";

    private List<Item> items;
    private Activity activity;

    public MainAdapter(Activity activity) {
        this.items = new ArrayList<>();
        this.activity = activity;
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void updateDateSet(List<Item> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=  LayoutInflater.from(parent.getContext());
        RowItemActivityBinding binding = RowItemActivityBinding
                .inflate(layoutInflater,parent,false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Item item = items.get(position);
        Context context = holder.itemView.getContext();
        Glide.with(context).load(item.getOwner().getAvatarUrl())
                .circleCrop().into(holder.binding.avatar);

        holder.binding.tvRepositoryName.setText(item.getName());
        holder.binding.tvDescription.setText(item.getDescription());
        holder.binding.tvForks.setText(item.getForksCount().toString());
        holder.binding.tvStars.setText(item.getStargazersCount().toString());
        holder.binding.tvUserName.setText(item.getOwner().getLogin());
        holder.binding.tvFullName.setText(item.getFullName());
        holder.itemView.setOnClickListener(view -> {
            urlRepository = item.getFullName().toString();
            getUserRepoURLDecoder();

            Intent i = new Intent(context, DetailsActivity.class);
            i.putExtra("user", user);
            i.putExtra("repo", repo);
            context.startActivity(i);
        });
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private RowItemActivityBinding binding;
        public MainViewHolder(RowItemActivityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        if(this.items != null) {
            return items.size();
        }
        return 0;
    }

    private void getUserRepoURLDecoder(){
        String decodedUrl = new URLDecoder().decode(urlRepository);
        String[] textoSeparado = decodedUrl.split("/");
        user = (textoSeparado[0]);
        repo = (textoSeparado[1]);
    }


}
