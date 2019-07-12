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

public class DisplayTraining extends AppCompatActivity {

    private ArrayList<String> mLieuMatch = new ArrayList<>();
    private ArrayList<String> mDateMatch = new ArrayList<>();
    private ArrayList<String> mTypeSport = new ArrayList<>();

    //@BindView(R.id.activity_main_bottom_navigation)
    //BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_training);
        ButterKnife.bind(this);
        remplirARAY();
    }



    private void remplirARAY(){
        mDateMatch.add("12/05/19");
        mLieuMatch.add("Paris");
        mTypeSport.add("Foot");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Marakech");
        mTypeSport.add("Tennis");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Lille");
        mTypeSport.add("Rugby");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Babibel");
        mTypeSport.add("Volley");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Amiens");
        mTypeSport.add("Roller");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Toulouse");
        mTypeSport.add("Foot");
        mDateMatch.add("12/08/2033");
        mLieuMatch.add("Espagne");
        mTypeSport.add("La chasse a la salope");
        mDateMatch.add("12/05/2033");
        mLieuMatch.add("Paris");
        mTypeSport.add("La salope sauvage");



        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.fragment_main_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mLieuMatch,mDateMatch,mTypeSport, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
