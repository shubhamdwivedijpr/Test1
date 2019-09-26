package com.example.test1.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.test1.Adapter.MyAdapter;
import com.example.test1.Model.Datum;
import com.example.test1.R;

import java.util.List;

public class ResponceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Datum> datumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responce);

        recyclerView =findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        if (getIntent().hasExtra("dataList")){
            datumList = getIntent().getParcelableArrayListExtra("dataList");

            if (datumList!=null && datumList.size()>0){
                recyclerView.setAdapter(new MyAdapter(datumList, R.layout.item, getApplicationContext()));

            }else{
                Toast.makeText(this, "Data Not Recive", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Data Not Fatch" +
                    "" +
                    "", Toast.LENGTH_SHORT).show();
        }



    }
} 
