package com.example.eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class segunda extends AppCompatActivity {
    private RatingBar rbr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        rbr1 = (RatingBar) findViewById(R.id.rbr1);
    }
    public void calificacion(View v) {
        Toast.makeText(segunda.this, "Has seleccionado un rating de: " + rbr1.getRating() + " estrellas!", Toast.LENGTH_SHORT).show();
    }
}