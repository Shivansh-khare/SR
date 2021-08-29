package com.example.sr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sr.Models.issued;
import com.example.sr.R;

import java.util.ArrayList;

public class Issued_books_adapter extends RecyclerView.Adapter<Issued_books_adapter.viewHldr> {

    ArrayList<issued> lst;

    public Issued_books_adapter(ArrayList<issued> lst){
        this.lst =lst;
    }
    @NonNull
    @Override
    public viewHldr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.issued_book_view,parent,false);
        return new viewHldr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHldr holder, int position) {
        holder.n.setText(lst.get(position).getName());
        holder.d.setText(lst.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    class viewHldr extends RecyclerView.ViewHolder{
        TextView n,d;
        public viewHldr(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.TV_book_name);
            d=itemView.findViewById(R.id.TV_book_date);
        }
    }
}
