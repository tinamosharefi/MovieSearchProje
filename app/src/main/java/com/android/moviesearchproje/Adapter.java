package com.android.moviesearchproje;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviesearchproje.imdb.Search;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MovieViewHolder> {

    List<Search> mylist;
    Adapter(List<Search> list){
        mylist = list;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item, parent, false);
        MovieViewHolder holder = new MovieViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String Title = mylist.get(position).getTitle();
        holder.txtTitle.setText("Title: " + Title);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
TextView txtTitle;
        public MovieViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Search search = mylist.get(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(),MovieActivity.class);
                    intent.putExtra("id",search.getImdbID());
                    itemView.getContext().startActivity(intent);

                }
            });



        }
    }
}
