package com.example.players_application;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayMatch extends AppCompatActivity {

    private ArrayList<String> mLieuMatch = new ArrayList<>();
    private ArrayList<String> mDateMatch = new ArrayList<>();
    private ArrayList<String> mTypeSport = new ArrayList<>();

    //@BindView(R.id.activity_main_bottom_navigation)
    //BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_match);
        ButterKnife.bind(this);

        remplirARAY();
    }



    private void remplirARAY(){
        mDateMatch.add("12/02/03");
        mLieuMatch.add("Paris");
        mTypeSport.add("Foot");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Marakeck");
        mTypeSport.add("Tennis");



        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.fragment_main_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mLieuMatch,mDateMatch,mTypeSport, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
