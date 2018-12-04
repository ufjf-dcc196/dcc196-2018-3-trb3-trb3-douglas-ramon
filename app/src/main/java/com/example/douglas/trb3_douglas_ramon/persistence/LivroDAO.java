package com.example.douglas.trb3_douglas_ramon.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class LivroDAO {


    private SQLiteDatabase db;
    private DbHelper banco;
    private String tabela = LivroContract.Livro.TABLE_NAME;
    private String name = LivroContract.Livro.COLUMN_NAME_NAME;
    private String numberOfPages = LivroContract.Livro.COLUMN_NAME_NUMBER_OF_PAGES;
    private String authors = LivroContract.Livro.COLUMN_NAME_AUTHORS;
    private String publisher = LivroContract.Livro.COLUMN_NAME_PUBLISHER;
    private String released = LivroContract.Livro.COLUMN_NAME_RELEASED;
    private String id = LivroContract.Livro._ID;

    private ContentValues valores = new ContentValues();
    private String[] campos = {name, numberOfPages, authors, publisher, released};
    private Cursor cursor;


    public LivroDAO(Context context) {
        banco = new DbHelper(context);
    }

    public void putHelper(ContentValues v, String _title, String _author, String _numberOfPages, String _publisher,
                          String _released) {
        v.put(name, _title);
        v.put(authors, _author);
        v.put(numberOfPages, _numberOfPages);
        v.put(publisher, _publisher);
        v.put(released, _released);
    }

    public String insereDado(String _title, String _author, String _publisher,
                             String _numberOfPages, String _released) {
        long resultado;
        db = banco.getWritableDatabase();

        putHelper(valores, _title, _author, _publisher, _numberOfPages, _released);
        resultado = db.insert(tabela, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Livro Inserido com sucesso";

    }

    public Cursor carregaDados() {
        db = banco.getReadableDatabase();
        cursor = db.query(tabela, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int _id) {
        String where = id + "=" + _id;
        db = banco.getReadableDatabase();
        cursor = db.query(tabela, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(String _id, String _title, String _author, String _numberOfPages, String _publisher,
                               String _released) {
        String where = id + "=" + _id;
        db = banco.getWritableDatabase();
        putHelper(valores, _title, _author, _numberOfPages, _publisher, _released);
        db.update(tabela, valores, where, null);
        db.close();
    }

    public void removeLivro(int _id) {
        String where = id + " = ?";
        String[] args = {String.valueOf(_id)};
        db = banco.getWritableDatabase();
        db.delete(tabela, where, args);
        db.close();
    }
}


