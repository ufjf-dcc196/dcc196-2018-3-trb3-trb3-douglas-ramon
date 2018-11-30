package com.example.douglas.trb3_douglas_ramon.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class LivroDAO {


    private SQLiteDatabase db;
    private DbHelper banco;
    private String tabela = LivroContract.Livro.TABLE_NAME;
    private String title = LivroContract.Livro.COLUMN_NAME_TITLE;
    private String subtitle = LivroContract.Livro.COLUMN_NAME_SUBTITLE;
    private String author = LivroContract.Livro.COLUMN_NAME_AUTHOR;
    private String publisher = LivroContract.Livro.COLUMN_NAME_PUBLISHER;
    private String publisherDate = LivroContract.Livro.COLUMN_NAME_PUBLISHER_DATE;
    private String description = LivroContract.Livro.COLUMN_NAME_DESCRIPTION;
    private String id = LivroContract.Livro.COLUMN_NAME_ID;

    private ContentValues valores = new ContentValues();
    private String[] campos = {title, subtitle, author, publisher, publisherDate};
    private Cursor cursor;


    public LivroDAO(Context context) {
        banco = new DbHelper(context);
    }

    public void putHelper(ContentValues v, String _title, String _subtitle, String _author, String _publisher,
                          String _publisherDate, String _description) {
        v.put(title, _title);
        v.put(subtitle, _subtitle);
        v.put(author, _author);
        v.put(publisher, _publisher);
        v.put(publisherDate, _publisherDate);
        v.put(description, _description);
    }

    public String insereDado(String _title, String _subtitle, String _author, String _publisher,
                             String _publisherDate, String _description) {
        long resultado;
        db = banco.getWritableDatabase();

        putHelper(valores, _title, _subtitle, _author, _publisher, _publisherDate, _description );
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

    public void alteraRegistro(String _id, String _title, String _subtitle, String _author, String _publisher,
                               String _publisherDate, String _description) {
        String where = id + "=" + _id;
        db = banco.getWritableDatabase();
        putHelper(valores, _title, _subtitle, _author, _publisher, _publisherDate, _description );
        db.update(tabela, valores, where, null);
        db.close();
    }
}


