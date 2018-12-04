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
    private OnLivroLongClickListener longClickListener;

    public interface OnLivroClickListener {
        void onLivroClick(View view, int position);
    }

    public interface OnLivroLongClickListener {
        void onLivroLongClickListener(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
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

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (longClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            longClickListener.onLivroLongClickListener(v, position);
                            return true;
                        }
                    }
                    return false;
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

        @Override
        public boolean onLongClick(View v) {
            if(longClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    longClickListener.onLivroLongClickListener(v, position);
                    return true;
                }
            }
            return false;
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
        viewHolder.txtNome.setText(livros.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public LivroAdapter(List<Livro> livros) {
        this.livros = livros;
    }

    public void setOnLivroClickListener(OnLivroClickListener listener) {
        this.listener = listener;
    }

    public void setOnLivroLongClickListener(OnLivroLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
}
