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

public class ListaLivrosActivity extends AppCompatActivity {

    private Button btnVoltar;
    private RecyclerView rclLivros;
    private List<Livro> livros = listaLivrosAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);


        btnVoltar = (Button) findViewById(R.id.btn_voltar_lista);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaLivrosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rclLivros = (RecyclerView) findViewById(R.id.rcl_lista_livros_api);
        rclLivros.setLayoutManager(new LinearLayoutManager(this));
        final LivroAdapter livroAdapter = new LivroAdapter(livros);
        rclLivros.setAdapter(livroAdapter);
    }

    private List<Livro> listaLivrosAPI() {
        final List<Livro> livros = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://anapioficeandfire.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LivroService livroService = retrofit.create(LivroService.class);

        for (int i = 1; i <= 10; i++) {
            Call<Livro> livro = livroService.getLivro(String.valueOf(i));
            livro.enqueue(new Callback<Livro>() {
                @Override
                public void onResponse(Call<Livro> call, Response<Livro> response) {
                    Livro livroResponse = response.body();
                    Log.i("LIVRO", "Livro: " + livroResponse.getName() + " - publisher: " + livroResponse.getPublisher() + " - number of pages: " + livroResponse.getNumberOfPages() + " - authors: " + livroResponse.getAuthors() + " - released: " + livroResponse.getReleased());

                    livros.add((Livro) livroResponse);
                }

                @Override
                public void onFailure(Call<Livro> call, Throwable t) {
                    Log.i("LIVRO", "onFailure: " + t.getMessage());
                }
            });
        }
        return livros;
    }
}
