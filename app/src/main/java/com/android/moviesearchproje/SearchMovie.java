package com.android.moviesearchproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.moviesearchproje.imdbProp.MovieProperties;

import java.util.ArrayList;
import java.util.List;

public class SearchMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        RecyclerView recycler = findViewById(R.id.searchedRecycler);
        final ImdbDatabase db = new ImdbDatabase(SearchMovie.this, "Imdb", null, 1);
        List<MovieProperties> searchedList = new ArrayList<>();
        searchedList = db.getMoviesDB();
        SearchedAdapter adapter = new SearchedAdapter(searchedList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(SearchMovie.this
                , RecyclerView.VERTICAL, false));
    }
    }

