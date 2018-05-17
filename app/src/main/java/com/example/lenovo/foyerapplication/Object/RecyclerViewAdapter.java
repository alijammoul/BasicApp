package com.example.lenovo.foyerapplication.Object;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.foyerapplication.Objects;
import com.example.lenovo.foyerapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 15/10/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Objects> oB = new ArrayList<>();



    public RecyclerViewAdapter(List<Objects> oB){

       this.oB=oB;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.id.setText(Integer.toString(oB.get(position).getId()));
        holder.userId.setText(Integer.toString(oB.get(position).getUserId()));
        holder.title.setText(oB.get(position).getTitle());
        holder.body.setText(oB.get(position).getBody());

    }


    @Override
    public int getItemCount() {
        return oB.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
TextView userId,id,title,body;

        public MyViewHolder(View itemView) {
            super(itemView);
            userId=(TextView) itemView.findViewById(R.id.userid);


            id=(TextView) itemView.findViewById(R.id.id);
            title=(TextView) itemView.findViewById(R.id.title);
            body=(TextView) itemView.findViewById(R.id.body);
        }
    }
}
