package com.example.pistock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pistock.api.ApiJavaMain;
import com.example.pistock.model.MainImageModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private int page =1;
    private RecyclerView recyclerView;
    private ArrayList<MainImageModel> list;
    private GridLayoutManager manager;
    private ImageAdapter adapter;
    private int pageSize = 30;
    private boolean isLoading ;
    private boolean isLastPage ;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
         adapter = new ImageAdapter(this,list);
         manager = new GridLayoutManager(this, 2);
         recyclerView.setLayoutManager(manager);
         recyclerView.setHasFixedSize(true);
         recyclerView.setAdapter(adapter);
         dialog = new ProgressDialog(this);
         dialog.setMessage("Loading");
         dialog.setCancelable(false);
         dialog.show();

         getData();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


    }

    private void getData() {
        isLoading = true;
        ApiJavaMain.getApiInterface().getImages(page,30).enqueue(new Callback<List<MainImageModel>>() {
            @Override
            public void onResponse(Call<List<MainImageModel>> call, Response<List<MainImageModel>> response) {
                if(response != null){
                    list.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
                isLoading = false;
                dialog.dismiss();

                if (list.size()>0){
                    isLastPage = list.size() < pageSize;
                }else {
                    isLastPage = true;
                }

            }

            @Override
            public void onFailure(Call<List<MainImageModel>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"Error : " + t.getMessage(),Toast.LENGTH_SHORT);
            }
        });
    }
}