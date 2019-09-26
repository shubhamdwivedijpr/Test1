package com.example.test1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test1.Model.Datum;
import com.example.test1.Model.Getpostresponce;
import com.example.test1.R;
import com.example.test1.Retrofit.ApiClient;
import com.example.test1.Retrofit.ApiInterface;
import com.example.test1.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(this);



    }

    public void onClick(View view){

        if(!Utils.isInternetConnected(this)){
            Toast.makeText(this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
        }

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<Getpostresponce> call=apiInterface.getresponcecall();
        Utils.showProgressDialog(this );
        call.enqueue(new Callback<Getpostresponce>() {
            @Override
            public void onResponse(Call<Getpostresponce> call, Response<Getpostresponce> response)
            {
                Utils.dismissProgressDialog();
               Getpostresponce getpostresponce  =  response.body();
                ArrayList<Datum> dataList = getpostresponce.getData();
                if(getpostresponce!=null)
                {
                    Intent intent =new Intent(MainActivity.this,ResponceActivity.class);
                    intent.putParcelableArrayListExtra("dataList",dataList);
                    startActivity(intent);


                }
                else {
                    Toast.makeText(MainActivity.this, "some thing went worng", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Getpostresponce> call, Throwable t)
            {
                Toast.makeText(MainActivity.this, "pls Try After some time", Toast.LENGTH_SHORT).show();
            }
        });








    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

