package com.example.douglas.trb3_douglas_ramon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.douglas.trb3_douglas_ramon.R;
import com.example.douglas.trb3_douglas_ramon.adapter.LivroAdapter;
import com.example.douglas.trb3_douglas_ramon.interfaces.LivroService;
import com.example.douglas.trb3_douglas_ramon.model.Livro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btnAdicionar;
    private RecyclerView rclLivros;
    public static List<Livro> livrosUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdicionar = (Button) findViewById(R.id.btn_adicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaLivrosActivity.class);
                startActivity(intent);
            }
        });

        rclLivros = (RecyclerView) findViewById(R.id.rcl_livros);
        rclLivros.setLayoutManager(new LinearLayoutManager(this));
        final LivroAdapter livroAdapter = new LivroAdapter(livrosUsuario);
        rclLivros.setAdapter(livroAdapter);
    }
}
