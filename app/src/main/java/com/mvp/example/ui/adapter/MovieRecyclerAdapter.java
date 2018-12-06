package com.mvp.example.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvp.example.R;
import com.mvp.example.data.model.Movie;

import java.util.ArrayList;
import java.util.List;


public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>
{
    private List<Movie> movieList;


    public MovieRecyclerAdapter()
    {
        this.movieList = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.bindMovie(movieList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

    public void setMovieList(List<Movie> movieList)
    {
        this.movieList.clear();
        this.movieList.addAll(movieList);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView label_name;
        TextView label_publisher;
        TextView label_created_by;
        ImageView thumbnail;

        public ViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);

            label_name = itemView.findViewById(R.id.label_name);
            label_publisher = itemView.findViewById(R.id.label_publisher);
            label_created_by = itemView.findViewById(R.id.label_createdby);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View v)
        {
            //clickListener.onItemClick(v, getAdapterPosition());
        }


        private void bindMovie(Movie movie)
        {
            label_name.setText(movie.getName());
            label_publisher.setText(movie.getPublisher());
            label_created_by.setText(movie.getCreatedBy());

            Glide.with(thumbnail.getContext()).load(movie.getImageUrl()).into(thumbnail);
        }
    }
}