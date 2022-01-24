package com.example.pistock.api;




import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiJavaMain {
    public static final String BaseUrl = "https://api.unsplash.com/";
    public static final String key = "UnS0tMj4YcdeSE84Snb-qSnXhvoJnhZw1Y6-L6n36xk";

    public static Retrofit retrofit = null;

    public static ApiInterface getApiInterface(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
