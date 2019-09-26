package com.example.test1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
        ;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.test1.Model.Datum;
import com.example.test1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Datum> datumList;
    private int rowLayout;
    private Context context;

    public MyAdapter(List<Datum> datnmList, int rowLayout, Context context) {
        this.datumList = datnmList;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.name.setText(datumList.get(i).getFullName());
        myViewHolder.phone.setText(datumList.get(i).getUserMobnum());
        myViewHolder.statement.setText(datumList.get(i).getViewType());
        Picasso.with(context).load(datumList.get(i).getProfileImg());


    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView  name;
        TextView phone;
        TextView statement;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            name = (TextView) itemView.findViewById(R.id.idname);
            phone = (TextView) itemView.findViewById(R.id.idphone);
            statement = (TextView) itemView.findViewById(R.id.idstatement);
            imageView=itemView.findViewById(R.id.image);


        }
    }
}
