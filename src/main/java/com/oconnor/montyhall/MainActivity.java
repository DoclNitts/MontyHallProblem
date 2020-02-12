package com.oconnor.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button threeDoorsButton;
    private Button explanationButton;
    private Button hundredDoorsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threeDoorsButton = (Button) findViewById(R.id.threeDoors);
        explanationButton = (Button) findViewById(R.id.explanation);
        hundredDoorsButton = (Button) findViewById(R.id.hundredDoors);

        threeDoorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThreeDoorsActivity();
            }
        });

        explanationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExplanationActivity();
            }
        });

        hundredDoorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHundredDoorsActivity();
            }
        });
    }

    public void openThreeDoorsActivity(){
        Intent intent = new Intent(this, ThreeDoors.class);
        startActivity(intent);
    }

    public void openExplanationActivity(){
        Intent intent = new Intent(this, Explanation.class);
        startActivity(intent);
    }

    public void openHundredDoorsActivity(){
        Intent intent = new Intent(this, HundredDoors.class);
        startActivity(intent);
    }
}
