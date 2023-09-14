package com.example.eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb1, cb2, cb3;
    private RecyclerView recyclerView;
    private itemAdapter itemAdap;
    private RadioButton rb1, rb2;
    private ProgressBar pb1;
    private Button boton1;
    private Button move;
    int fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        boton1 = (Button) findViewById(R.id.boton1);
        move=findViewById(R.id.move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, segunda.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        itemAdap = new itemAdapter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        itemAdap.setData(getData());
        recyclerView.setAdapter(itemAdap);
        recyclerView.setLayoutManager(llm);
        progressBar();
    }

    private List<item> getData() {
        List<item> list = new ArrayList<>();
        list.add(new item(R.drawable.ia, "Inteligencia artificial"));
        list.add(new item(R.drawable.mc, "Minecraft"));
        return list;
    }

    public void comprobarCB(View v) {
        String comprobarCB1 = "";
        String comprobarCB2 = "";
        String comprobarCB3 = "";
        String etiqueta = null;
        if (cb1.isChecked() == true)
            comprobarCB1 = cb1.getText().toString();
        if (cb2.isChecked() == true)
            comprobarCB2 = cb2.getText().toString();
        if (cb3.isChecked() == true)
            comprobarCB3 = cb3.getText().toString();
        if (comprobarCB1 == "" && comprobarCB2 == "" && comprobarCB3 == "") {
            Toast.makeText(MainActivity.this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
        } else {
            etiqueta = (comprobarCB1 + " " + comprobarCB2 + " " + comprobarCB3);
            Toast.makeText(MainActivity.this, "Las opciones seleccionadas son: " + etiqueta, Toast.LENGTH_SHORT).show();
        }

    }

    public void comprobarRB(View v) {
        String tipo = "";
        if (rb1.isChecked()) {
            tipo = rb1.getText().toString();
        } else {
            tipo = rb2.getText().toString();
        }
        Toast.makeText(MainActivity.this, "La opcion seleccionada es: " + tipo, Toast.LENGTH_SHORT).show();
    }

    public void progressBar() {
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        fr++;
                        pb1.setProgress(fr);
                        if (fr == 100)
                            t.cancel();
                    }
                };
                t.schedule(tt, 0, 100);
            }
        });
    }
}