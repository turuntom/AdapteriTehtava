package com.example.tuntiesimerkkiadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<Date> lista;

    ArrayAdapter<String> stringArrayAdapter;

    OmaAdapteri dateArrayAdapter;

    Button nappi;

    AlertDialog.Builder ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<>();





        //stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        
        dateArrayAdapter = new OmaAdapteri(MainActivity.this,R.layout.omaleiska, lista);
        
        listView = findViewById(R.id.listaViewi);

        listView.setAdapter(dateArrayAdapter);




        ab = new AlertDialog.Builder(this);



        nappi = findViewById(R.id.button);

        View.OnClickListener kuuntelija = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mainacitvity kuutenlija", Toast.LENGTH_SHORT).show();
                dateArrayAdapter.add(new Date());

            }
        };

        nappi.setOnClickListener(kuuntelija);

    }
}
