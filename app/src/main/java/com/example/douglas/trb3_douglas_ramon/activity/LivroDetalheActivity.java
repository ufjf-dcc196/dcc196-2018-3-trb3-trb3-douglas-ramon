package com.example.douglas.trb3_douglas_ramon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.douglas.trb3_douglas_ramon.R;
import com.example.douglas.trb3_douglas_ramon.model.Livro;
import com.example.douglas.trb3_douglas_ramon.persistence.LivroDAO;

public class LivroDetalheActivity extends AppCompatActivity {

    private Button btnAdicionar;
    private Button btnVoltar;
    private TextView txtTitulo;
    private TextView txtAutor;
    private TextView txtEditora;
    private TextView txtRelease;
    private TextView txtPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_detalhe);

        txtTitulo = (TextView) findViewById(R.id.txt_nome);
        txtAutor = (TextView) findViewById(R.id.txt_autor);
        txtEditora = (TextView) findViewById(R.id.txt_editora);
        txtRelease = (TextView) findViewById(R.id.txt_release);
        txtPaginas = (TextView) findViewById(R.id.txt_paginas);

        btnVoltar = (Button) findViewById(R.id.btn_voltar_ld);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LivroDetalheActivity.this, ListaLivrosActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        int positcao = bundle.getInt("posicao");
        final Livro livro = ListaLivrosActivity.livros.get(positcao);
        txtTitulo.setText(livro.getName());
        txtAutor.setText(livro.getAuthors().get(0));
        txtEditora.setText(livro.getPublisher());
        txtRelease.setText(livro.getReleased());
        txtPaginas.setText(livro.getNumberOfPages());

        btnAdicionar = (Button) findViewById(R.id.btn_adicionar_ld);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LivroDetalheActivity.this, MainActivity.class);
                LivroDAO crud = new LivroDAO(getBaseContext());
                crud.insereDado(livro.getName(), livro.getAuthors().get(0), livro.getPublisher(), livro.getNumberOfPages(), livro.getReleased());
                MainActivity.livrosUsuario.add(livro);
                startActivity(intent);
            }
        });

    }
}
