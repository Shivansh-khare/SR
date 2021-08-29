package com.example.sr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sr.R;
import com.example.sr.cs_second_yr;
import com.example.sr.directory;
import com.example.sr.directory_btech;

import java.util.ArrayList;

public class cs_second_adapter extends RecyclerView.Adapter<cs_second_adapter.view_holder> {
    ArrayList<String> list;
    Context context;
    int pge;

    public interface a {
        void onclicked(int pos,int pge,Context context);
    };

    cs_second_adapter.a x;

    public cs_second_adapter(ArrayList<String> list, Context context, int pge) {
        this.list = list;
        this.context = context;
        this.pge = pge;
        x = (cs_second_yr)context;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_direc_lay,parent,false);
        return new cs_second_adapter.view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        holder.itemView.setTag(list.get(position));
        holder.Tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class view_holder extends RecyclerView.ViewHolder {
        TextView Tv;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            Tv = itemView.findViewById(R.id.tv_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x.onclicked(list.indexOf(itemView.getTag()),pge,context);

                }
            });
        }
    }
}
