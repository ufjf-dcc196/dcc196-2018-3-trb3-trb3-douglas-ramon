package com.example.douglas.trb3_douglas_ramon.persistence;

import android.provider.BaseColumns;

public class LivroContract {

    public static final class Livro implements BaseColumns {
        public static final String TABLE_NAME = "livro";
        public static final String COLUMN_NAME_ID= "_ID";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_PUBLISHER = "publisher";
        public static final String COLUMN_NAME_PUBLISHER_DATE = "publisherDate";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }

    public static final String CREATE_EVENTO = "CREATE TABLE " + Livro.TABLE_NAME + " ("
            + Livro._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Livro.COLUMN_NAME_TITLE + " TEXT, "
            + Livro.COLUMN_NAME_SUBTITLE + " TEXT, "
            + Livro.COLUMN_NAME_AUTHOR + " TEXT, "
            + Livro.COLUMN_NAME_PUBLISHER + " TEXT, "
            + Livro.COLUMN_NAME_PUBLISHER_DATE + " TEXT"
            + Livro.COLUMN_NAME_DESCRIPTION + " TEXT"
            + ")";

    public final static String DROP_EVENTO = "DROP TABLE IF EXISTS " + Livro.TABLE_NAME;

    public LivroContract() {
    }
}
