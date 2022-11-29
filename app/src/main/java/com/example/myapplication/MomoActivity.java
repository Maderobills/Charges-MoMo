package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MomoActivity extends AppCompatActivity {
    private ImageButton imageButton3,imageButton2,imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.momo);

        imageButton3 = findViewById(R.id.imageButton3);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton = findViewById(R.id.imageButton);


        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMtnActivity();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVodaActivity();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAirTigoActivity();
            }
        });
    }

    public void openMtnActivity() {
        Intent intent = new Intent(this,MtnActivity.class);
        startActivity(intent);
    }
    public void openVodaActivity() {
        Intent intent = new Intent(this,VodaActivity.class);
        startActivity(intent);
    }
    public void openAirTigoActivity() {
        Intent intent = new Intent(this,AirTigoActivity.class);
        startActivity(intent);
    }
}
