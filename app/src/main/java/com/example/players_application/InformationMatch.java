package com.example.players_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_match);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("date_info") && getIntent().hasExtra("type_sport") && getIntent().hasExtra("location_event")){
            String date = getIntent().getStringExtra("date_info");
            String sport = getIntent().getStringExtra("type_sport");
            String location = getIntent().getStringExtra("location_event");
            setInfo(date, sport, location);
        }
    }
    private void setInfo(String date, String sport, String location){

        TextView locationEvent = findViewById(R.id.locationEvent);
        TextView dateEvent = findViewById(R.id.dateEventInformation);
        TextView type = findViewById(R.id.typeSportInformation);
        dateEvent.setText(date);
        type.setText(sport);
        locationEvent.setText(location);
    }
}
