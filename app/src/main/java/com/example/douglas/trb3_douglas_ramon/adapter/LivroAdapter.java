package com.example.douglas.trb3_douglas_ramon.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.douglas.trb3_douglas_ramon.R;
import com.example.douglas.trb3_douglas_ramon.model.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {
    private List<Livro> livros;
    private OnLivroClickListener listener;

    public interface OnLivroClickListener {
        void onLivroClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.item_nome);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onLivroClick(v, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            if(listener != null) {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    listener.onLivroClick(v, position);
                }
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View linhaLivro = inflater.inflate(R.layout.lista_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(linhaLivro);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtNome.setText(livros.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public LivroAdapter(List<Livro> livros) {
        this.livros = livros;
    }

    public void setOnLivroClickListe(OnLivroClickListener listener) {
        this.listener = listener;
    }
}
