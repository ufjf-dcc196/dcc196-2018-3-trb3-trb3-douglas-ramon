package com.example.douglas.trb3_douglas_ramon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

    private RecyclerView rclLivros;
    public static List<Livro> livrosUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://anapioficeandfire.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LivroService livroService = retrofit.create(LivroService.class);

        Call<Livro> livro = livroService.getLivro("1");
        livro.enqueue(new Callback<Livro>() {
            @Override
            public void onResponse(Call<Livro> call, Response<Livro> response) {
                Livro livroResponse = response.body();
                Log.i("LIVRO", "Livro: " + livroResponse.getName() + " - publisher: " + livroResponse.getPublisher() + " - number of pages: " + livroResponse.getNumberOfPages() + " - authors: " + livroResponse.getAuthors() + " - released: " + livroResponse.getReleased());
            }

            @Override
            public void onFailure(Call<Livro> call, Throwable t) {
                Log.i("LIVRO", "onFailure: " + t.getMessage());
            }
        });

        rclLivros = (RecyclerView) findViewById(R.id.rcl_livros);
        rclLivros.setLayoutManager(new LinearLayoutManager(this));
        final LivroAdapter livroAdapter = new LivroAdapter(livrosUsuario);
        rclLivros.setAdapter(livroAdapter);
    }
}
