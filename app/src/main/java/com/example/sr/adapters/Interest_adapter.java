package com.example.sr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sr.R;
import com.example.sr.Models.interest_model;

import java.util.ArrayList;

public class Interest_adapter extends RecyclerView.Adapter<Interest_adapter.viewHOlder> {

    ArrayList<interest_model> lst;

    public Interest_adapter(ArrayList<interest_model> lst) {
        this.lst = lst;
    }

    @NonNull
    @Override
    public viewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_view,parent,false);
        return new viewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHOlder holder, int position) {
        holder.tv_inte.setText(lst.get(position).getName());
        holder.rb_inte.setRating(lst.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    class viewHOlder extends RecyclerView.ViewHolder {
        TextView tv_inte;
        RatingBar rb_inte;
        public viewHOlder(@NonNull View itemView) {
            super(itemView);
            tv_inte = itemView.findViewById(R.id.TV_inte);
            rb_inte = itemView.findViewById(R.id.inte_rating);
        }
    }
}
