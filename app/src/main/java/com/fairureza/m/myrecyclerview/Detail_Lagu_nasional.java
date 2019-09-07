package com.fairureza.m.myrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Detail_Lagu_nasional extends AppCompatActivity {
    public static final String EXTRA = "extra";
    ImageView Photo;
    TextView Name, From;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__lagu_nasional);
        Photo = findViewById(R.id.img_lagu);
        Name = findViewById(R.id.tv_name);
        From = findViewById(R.id.tv_from);


        Intent ss = getIntent();
        lagu_nasional lagunas = ss.getParcelableExtra(EXTRA);

        Name.setText(lagunas.getName());
        From.setText(lagunas.getFrom());
        Glide.with(this)
                .load(lagunas.getPhoto())
                .apply(new RequestOptions().override(220,220))
                .into(Photo);
    }
}
