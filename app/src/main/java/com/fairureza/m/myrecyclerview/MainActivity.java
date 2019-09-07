package com.fairureza.m.myrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_lgunasional;
    private ArrayList<lagu_nasional> list = new ArrayList<>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_lgunasional = findViewById(R.id.rv_hero);
        rv_lgunasional.setHasFixedSize(true);


        list.addAll(nasional.getListData());
        showRecyclerList();
    }


    private void showRecyclerList() {
        rv_lgunasional.setLayoutManager(new LinearLayoutManager(this));
        ListlaguAdapter listHeroAdapter = new ListlaguAdapter(list, this);
        rv_lgunasional.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListlaguAdapter.OnItemClickCallback() {

            @Override
            public void onItemClicked(lagu_nasional data) {
                Intent sdds = new Intent(MainActivity.this, Detail_Lagu_nasional.class);
                sdds.putExtra(Detail_Lagu_nasional.EXTRA, data);
                startActivity(sdds);
            }
        });
    }

    private void showRecyclerGrid() {
        rv_lgunasional.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list, this);
        rv_lgunasional.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(lagu_nasional data) {

                Intent wardun = new Intent(MainActivity.this, Detail_Lagu_nasional.class);
                wardun.putExtra(Detail_Lagu_nasional.EXTRA, data);
                startActivity(wardun);

            }
        });
    }

    private void showRecyclerCardView() {
        rv_lgunasional.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list, this);
        rv_lgunasional.setAdapter(cardViewHeroAdapter);
        cardViewHeroAdapter.setOnItemClickCallback(new CardViewHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(lagu_nasional data) {
                Intent wardun = new Intent(MainActivity.this, Detail_Lagu_nasional.class);
                wardun.putExtra(Detail_Lagu_nasional.EXTRA, data);
                startActivity(wardun);

            }
        });
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
//    private void showSelectedHero(lagu_nasional hero) {
//          //  Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
//        Intent detail=new Intent(this,Detail_Lagu_nasional.class);
//        startActivity(detail);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showAbout();
                break;
        }
    }

    public void showAbout() {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
