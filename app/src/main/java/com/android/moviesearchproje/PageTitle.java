package com.android.moviesearchproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.moviesearchproje.imdb.MovieList;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PageTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_title);
          Intent intent=getIntent();
          String title=intent.getStringExtra("title");
          String address = "https://www.omdbapi.com/?s="+title+"&apikey=70ad462a";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(address, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                final MovieList movieList = gson.fromJson(response.toString(), MovieList.class);
                RecyclerView moviesRecycler = findViewById(R.id.recyclertitle);
                Adapter adapter = new Adapter(movieList.getSearch());
                moviesRecycler.setAdapter(adapter);
                moviesRecycler.setLayoutManager(new LinearLayoutManager(PageTitle.this
                        , RecyclerView.VERTICAL, false));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });}}

