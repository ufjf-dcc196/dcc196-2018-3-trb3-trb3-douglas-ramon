package com.example.douglas.trb3_douglas_ramon.persistence;

import android.provider.BaseColumns;

public class LivroContract {

    public static final class Livro implements BaseColumns {
        public static final String TABLE_NAME = "livro";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PUBLISHER = "publisher";
        public static final String COLUMN_NAME_NUMBER_OF_PAGES = "numberOfPages";
        public static final String COLUMN_NAME_AUTHORS = "authors";
        public static final String COLUMN_NAME_RELEASED = "released";
    }

    public static final String CREATE_LIVRO = "CREATE TABLE " + Livro.TABLE_NAME + " ("
            + Livro._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Livro.COLUMN_NAME_NAME + " TEXT, "
            + Livro.COLUMN_NAME_NUMBER_OF_PAGES + " TEXT, "
            + Livro.COLUMN_NAME_AUTHORS + " TEXT, "
            + Livro.COLUMN_NAME_PUBLISHER + " TEXT, "
            + Livro.COLUMN_NAME_RELEASED + " TEXT"
            + ")";

    public final static String DROP_LIVRO = "DROP TABLE IF EXISTS " + Livro.TABLE_NAME;

    public LivroContract() {
    }
}
