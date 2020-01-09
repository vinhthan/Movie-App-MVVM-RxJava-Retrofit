package com.example.moviemvvmrxjavaretrofit.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviemvvmrxjavaretrofit.R;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;

import java.util.List;

public class MoviePopularAdapter extends RecyclerView.Adapter<MoviePopularAdapter.ViewHolder> {
    private List<MoviePopular.Results> list;
    private Context context;

    public MoviePopularAdapter(List<MoviePopular.Results> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviePopular.Results movie = list.get(position);

        holder.txvTitle.setText(movie.getTitle());
        Glide.with(context).load(movie.getBackdropPath()).into(holder.imgBackdropPath);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTitle;
        private ImageView imgBackdropPath;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvTitle = itemView.findViewById(R.id.txvTitle);
            imgBackdropPath = itemView.findViewById(R.id.imgBackdropPath);
        }
    }
}
