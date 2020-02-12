package com.oconnor.montyhall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.DecimalFormat;


public class ThreeDoors extends AppCompatActivity {


    DecimalFormat d = new DecimalFormat("0.00");
    DecimalFormat d2 = new DecimalFormat("0");

    private ImageButton button1, button2, button3;
    private TextView statsStayed, statsSwitched;
    private Button reset, goAgain;
    ImageButton buttons[] = new ImageButton[3];
    int buttonsClicked = 0;
    int buttonClicked;
    int firstClicked;
    int carDoor = 0 + (int) (Math.random() * 3);
    double switched, stayed, switchedAndWon, stayedAndWon;
    boolean isWon = false;
    boolean openDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_doors);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset = (Button) findViewById(R.id.reset);
        goAgain = (Button) findViewById(R.id.goAgain);

        button1 = (ImageButton) findViewById(R.id.threeDoor1);
        button2 = (ImageButton) findViewById(R.id.threeDoor2);
        button3 = (ImageButton) findViewById(R.id.threeDoor3);

        statsStayed = (TextView) findViewById(R.id.statsStayed);
        statsSwitched = (TextView) findViewById(R.id.statsSwitched);

        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;

        carDoor = 0 + (int) (Math.random() * 3);
        buttons[carDoor].setImageResource(R.drawable.closeddoor);

        statsStayed.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
        statsSwitched.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 3);
                }
                buttonsClicked++;
                buttonClicked = 0;

                if (buttonsClicked == 1) {
                    firstClicked = 0;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 2; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 0) {
                                int y = 1;
                                buttons[y].setImageResource(R.drawable.goatdoor);
                                buttons[y].setClickable(false);
                            } else {
                                buttons[x].setImageResource(R.drawable.goatdoor);
                                buttons[x].setClickable(false);
                            }
                        }
                    }
                }

                if (buttonsClicked == 2) {
                    //sets correct door to Car door
                    buttons[carDoor].setImageResource(R.drawable.cardoor);


                    if (buttonClicked == carDoor){
                        isWon = true;
                    }

                    if (firstClicked != buttonClicked){
                        switched++;
                        if (isWon){
                            switchedAndWon++;
                        }
                    }

                    if (firstClicked == buttonClicked){
                        stayed++;
                        if (isWon){
                            stayedAndWon++;
                        }
                    }

                    //sets wrong doors to goat door
                    for (int x = 0; x <= 2; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));
                    //resets carDoor
                    carDoor = 0 + (int) (Math.random() * 3);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 3);
                }
                buttonsClicked++;
                buttonClicked = 1;

                if (buttonsClicked == 1) {
                    firstClicked = 1;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 2; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 1) {
                                int y = 2;
                                buttons[y].setImageResource(R.drawable.goatdoor);
                                buttons[y].setClickable(false);
                            } else {
                                buttons[x].setImageResource(R.drawable.goatdoor);
                                buttons[x].setClickable(false);
                            }
                        }
                    }
                }

                if (buttonsClicked == 2) {
                    //sets correct door to Car door
                    buttons[carDoor].setImageResource(R.drawable.cardoor);


                    if (buttonClicked == carDoor){
                        isWon = true;
                    }

                    if (firstClicked != buttonClicked){
                        switched++;
                        if (isWon){
                            switchedAndWon++;
                        }
                    }

                    if (firstClicked == buttonClicked){
                        stayed++;
                        if (isWon){
                            stayedAndWon++;
                        }
                    }

                    //sets wrong doors to goat door
                    for (int x = 0; x <= 2; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));
                    //resets carDoor
                    carDoor = 0 + (int) (Math.random() * 3);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 3);
                }
                buttonsClicked++;
                buttonClicked = 2;

                if (buttonsClicked == 1) {
                    firstClicked = 2;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 2; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 2) {
                                int y = 0;
                                buttons[y].setImageResource(R.drawable.goatdoor);
                                buttons[y].setClickable(false);
                            } else {
                                buttons[x].setImageResource(R.drawable.goatdoor);
                                buttons[x].setClickable(false);
                            }
                        }
                    }
                }

                if (buttonsClicked == 2) {
                    //sets correct door to Car door
                    buttons[carDoor].setImageResource(R.drawable.cardoor);


                    if (buttonClicked == carDoor){
                        isWon = true;
                    }

                    if (firstClicked != buttonClicked){
                        switched++;
                        if (isWon){
                            switchedAndWon++;
                        }
                    }

                    if (firstClicked == buttonClicked){
                        stayed++;
                        if (isWon){
                            stayedAndWon++;
                        }
                    }

                    //sets wrong doors to goat door
                    for (int x = 0; x <= 2; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));
                    //resets carDoor
                    carDoor = 0 + (int) (Math.random() * 3);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isWon = false;
                openDoor = false;
                stayed = 0;
                stayedAndWon = 0;
                switched = 0;
                switchedAndWon = 0;
                buttonClicked = -1;
                firstClicked = -1;
                buttonsClicked = 0;
                statsStayed.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                statsSwitched.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));
                for (int x = 0; x <= 2; x++) {
                    buttons[x].setImageResource(R.drawable.closeddoor);
                    buttons[x].setClickable(true);
                }
            }
        });

        goAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isWon = false;
                openDoor = false;
                buttonClicked = -1;
                firstClicked = -1;
                buttonsClicked = 0;
                for (int x = 0; x <= 2; x++) {
                    buttons[x].setImageResource(R.drawable.closeddoor);
                    buttons[x].setClickable(true);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home);{
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}


