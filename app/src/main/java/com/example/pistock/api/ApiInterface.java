package com.example.pistock.api;

import com.example.pistock.model.ImageModel;
import com.example.pistock.model.SearchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.example.pistock.api.ApiJavaMain.key;

public interface ApiInterface {

    @Headers("Authorization = ClientId" + key)
    @GET("/photos")
    Call<List<ImageModel>> getImages(
            @Query("page") int page,
            @Query("PerPage") int PerPage
    );

    @Headers("Authorization = ClientId" + key)
    @GET("/search/photos")
    Call<SearchModel> SearchImages(
            @Query("query") String query
    );
}
