package com.example.fragmentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private ArrayList<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, rating, year;
        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            rating = (TextView) view.findViewById(R.id.rating);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

    public MovieAdapter(ArrayList<Movie> moviesList){
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movies_list_fix, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(movie.getRating());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount(){
        return moviesList.size();
    }
}
