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
import com.example.moviemvvmrxjavaretrofit.data.model.api.MovieUpcoming;
import java.util.List;

public class MovieUpcomingAdapter extends RecyclerView.Adapter<MovieUpcomingAdapter.ViewHolder> {
    private List<MovieUpcoming.Results> list;
    private Context context;

    public MovieUpcomingAdapter(List<MovieUpcoming.Results> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_upcoming, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieUpcoming.Results movie = list.get(position);

        holder.txvTitleUp.setText(movie.getTitle());
        Glide.with(context).load(movie.getBackdropPath()).into(holder.imgBackdropPathUp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTitleUp;
        private ImageView imgBackdropPathUp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvTitleUp = itemView.findViewById(R.id.textView);
            imgBackdropPathUp = itemView.findViewById(R.id.imgBackdropPath);
        }
    }
}
