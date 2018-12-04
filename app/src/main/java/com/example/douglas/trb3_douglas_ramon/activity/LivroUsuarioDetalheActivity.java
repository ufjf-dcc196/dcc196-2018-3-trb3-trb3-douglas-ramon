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

public class LivroUsuarioDetalheActivity extends AppCompatActivity {

    private Button btnVoltar;
    private Button btnRemover;
    private TextView txtTitulo;
    private TextView txtAutor;
    private TextView txtEditora;
    private TextView txtReleased;
    private TextView txtPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_usuario_detalhe);

        txtTitulo = (TextView) findViewById(R.id.txt_titulo_lud);
        txtAutor = (TextView) findViewById(R.id.txt_autor_lud);
        txtEditora = (TextView) findViewById(R.id.txt_editora_lud);
        txtReleased = (TextView) findViewById(R.id.txt_publicacao_lud);
        txtPaginas = (TextView) findViewById(R.id.txt_paginas_lud);

        btnVoltar = (Button) findViewById(R.id.btn_voltar_lud);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LivroUsuarioDetalheActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        int posicao = bundle.getInt("posicao");
        final Livro livro = MainActivity.livrosUsuario.get(posicao);

        txtTitulo.setText(livro.getName());
        txtAutor.setText(livro.getAuthors().get(0));
        txtEditora.setText(livro.getPublisher());
        txtReleased.setText(livro.getReleased());
        txtPaginas.setText(livro.getNumberOfPages());

        btnRemover = (Button) findViewById(R.id.btn_remover);
        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LivroUsuarioDetalheActivity.this, MainActivity.class);
                LivroDAO crud = new LivroDAO(getBaseContext());
                crud.removeLivro(livro.getId());
                MainActivity.livrosUsuario = MainActivity.listaLivrosUsuario();
                startActivity(intent);
            }
        });
    }
}
