package com.example.moviemvvmrxjavaretrofit.ui.home.adapter;

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
    private ItemClickListenerPopular itemClickListenerPopular;

    public MoviePopularAdapter(List<MoviePopular.Results> list, Context context, ItemClickListenerPopular itemClickListenerPopular) {
        this.list = list;
        this.context = context;
        this.itemClickListenerPopular = itemClickListenerPopular;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_popular, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviePopular.Results movie = list.get(position);

        holder.txvTitlePopular.setText(movie.getTitle());
        Glide.with(context).load(movie.getBackdropPath()).into(holder.imgBackdropPathPopular);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTitlePopular;
        private ImageView imgBackdropPathPopular;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvTitlePopular = itemView.findViewById(R.id.txvTitlePopular);
            imgBackdropPathPopular = itemView.findViewById(R.id.imgBackdropPathPopular);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListenerPopular.onClickPopular(getPosition());
                }
            });

        }
    }

}
