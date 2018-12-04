package com.example.douglas.trb3_douglas_ramon.activity;

import android.content.Intent;
import android.database.Cursor;
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
import com.example.douglas.trb3_douglas_ramon.persistence.DbHelper;
import com.example.douglas.trb3_douglas_ramon.persistence.LivroContract;

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
    public static DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(getApplicationContext());
        livrosUsuario = listaLivrosUsuario();

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
        livroAdapter.setOnLivroClickListener(new LivroAdapter.OnLivroClickListener() {
            @Override
            public void onLivroClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, LivroUsuarioDetalheActivity.class);
                intent.putExtra("posicao", position);
                startActivity(intent);
            }
        });
    }

    public static List<Livro> listaLivrosUsuario() {
        List<Livro> livros = new ArrayList<>();
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from " + LivroContract.Livro.TABLE_NAME, null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(LivroContract.Livro._ID));
            String titulo = cursor.getString(cursor.getColumnIndexOrThrow(LivroContract.Livro.COLUMN_NAME_NAME));
            final String autor = cursor.getString(cursor.getColumnIndexOrThrow(LivroContract.Livro.COLUMN_NAME_AUTHORS));
            String publisher = cursor.getString(cursor.getColumnIndexOrThrow(LivroContract.Livro.COLUMN_NAME_PUBLISHER));
            String numberOfPages = cursor.getString(cursor.getColumnIndexOrThrow(LivroContract.Livro.COLUMN_NAME_NUMBER_OF_PAGES));
            String released = cursor.getString(cursor.getColumnIndexOrThrow(LivroContract.Livro.COLUMN_NAME_RELEASED));
            List<String> autores = new ArrayList<>();
            autores.add(autor);
            Livro livro = new Livro();
            livro
                    .setReleased(released)
                    .setPublisher(publisher)
                    .setNumberOfPages(numberOfPages)
                    .setName(titulo)
                    .setAuthors(autores)
                    .setId(id);
            livros.add(livro);
        }
        return livros;
    }
}
