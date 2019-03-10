package com.example.player_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mChooseCategory;
    private Button mMatchButton;
    private Button mTrainingButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChooseCategory = (TextView) findViewById(R.id.titleActivity);
        mMatchButton = (Button) findViewById(R.id.matchActivity);
        mTrainingButton = (Button) findViewById(R.id.trainingActivity);

    }
}
