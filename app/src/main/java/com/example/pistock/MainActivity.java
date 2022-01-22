package com.example.pistock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        EditText editText;
        ImageButton imgBtn;

        button = findViewById(R.id.btnSearch);
        editText = findViewById(R.id.etSearch);
        imgBtn = findViewById(R.id.imgInfo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchString = editText.getText().toString();

                Toast.makeText(getApplicationContext(),searchString,Toast.LENGTH_SHORT).show();
            }
        });

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Info pannel",Toast.LENGTH_SHORT).show();
            }
        });



    }
}