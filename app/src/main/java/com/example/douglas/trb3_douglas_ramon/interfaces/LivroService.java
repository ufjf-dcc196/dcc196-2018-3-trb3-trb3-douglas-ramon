package com.example.douglas.trb3_douglas_ramon.interfaces;


import com.example.douglas.trb3_douglas_ramon.model.Livro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LivroService {
    @GET("https://www.googleapis.com/books/v1/volumes?q=search+terms")
    Call<Livro> getLivro(@Path("items") String livro);

}
