package com.oconnor.montyhall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class HundredDoors extends AppCompatActivity {

    DecimalFormat d = new DecimalFormat("0.00");
    DecimalFormat d2 = new DecimalFormat("0");

    private ImageButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20;
    private TextView statsStayed2, statsSwitched2;
    private Button reset2, goAgain2;
    ImageButton buttons[] = new ImageButton[20];
    int buttonsClicked = 0;
    int buttonClicked;
    int firstClicked;
    int carDoor = 0 + (int) (Math.random() * 20);
    double switched, stayed, switchedAndWon, stayedAndWon;
    boolean isWon = false;
    boolean openDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hundred_doors);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset2 = (Button) findViewById(R.id.reset2);
        goAgain2 = (Button) findViewById(R.id.goAgain2);

        statsStayed2 = (TextView) findViewById(R.id.statsStayed2);
        statsSwitched2 = (TextView) findViewById(R.id.statsSwitched2);

        statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
        statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

        button1 = (ImageButton) findViewById(R.id.door1);
        button2 = (ImageButton) findViewById(R.id.door2);
        button3 = (ImageButton) findViewById(R.id.door3);
        button4 = (ImageButton) findViewById(R.id.door4);
        button5 = (ImageButton) findViewById(R.id.door5);
        button6 = (ImageButton) findViewById(R.id.door6);
        button7 = (ImageButton) findViewById(R.id.door7);
        button8 = (ImageButton) findViewById(R.id.door8);
        button9 = (ImageButton) findViewById(R.id.door9);
        button10 = (ImageButton) findViewById(R.id.door10);
        button11 = (ImageButton) findViewById(R.id.door11);
        button12 = (ImageButton) findViewById(R.id.door12);
        button13 = (ImageButton) findViewById(R.id.door13);
        button14 = (ImageButton) findViewById(R.id.door14);
        button15 = (ImageButton) findViewById(R.id.door15);
        button16 = (ImageButton) findViewById(R.id.door16);
        button17 = (ImageButton) findViewById(R.id.door17);
        button18 = (ImageButton) findViewById(R.id.door18);
        button19 = (ImageButton) findViewById(R.id.door19);
        button20 = (ImageButton) findViewById(R.id.door20);

        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        buttons[6] = button7;
        buttons[7] = button8;
        buttons[8] = button9;
        buttons[9] = button10;
        buttons[10] = button11;
        buttons[11] = button12;
        buttons[12] = button13;
        buttons[13] = button14;
        buttons[14] = button15;
        buttons[15] = button16;
        buttons[16] = button17;
        buttons[17] = button18;
        buttons[18] = button19;
        buttons[19] = button20;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 0;

                if (buttonsClicked == 1) {
                    firstClicked = 0;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 0) {
                                int list[] = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 1;

                if (buttonsClicked == 1) {
                    firstClicked = 1;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 1) {
                                int list[] = {0, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 2;

                if (buttonsClicked == 1) {
                    firstClicked = 2;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 2) {
                                int list[] = {0, 1, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 3;

                if (buttonsClicked == 1) {
                    firstClicked = 3;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 3) {
                                int list[] = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 4;

                if (buttonsClicked == 1) {
                    firstClicked = 4;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 4) {
                                int list[] = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 5;

                if (buttonsClicked == 1) {
                    firstClicked = 5;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 5) {
                                int list[] = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ,16 ,17, 18};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 6;

                if (buttonsClicked == 1) {
                    firstClicked = 6;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 6) {
                                int list[] = {0, 1, 2, 3, 4, 5, 7, 8, 10, 11, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 7;

                if (buttonsClicked == 1) {
                    firstClicked = 7;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 7) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 8;

                if (buttonsClicked == 1) {
                    firstClicked = 8;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 8) {
                                int list[] = {0, 1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 9;

                if (buttonsClicked == 1) {
                    firstClicked = 9;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 9) {
                                int list[] = {0, 1, 2, 3, 4, 6, 7, 8, 10, 11, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 10;

                if (buttonsClicked == 1) {
                    firstClicked = 10;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 10) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15 ,16, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 11;

                if (buttonsClicked == 1) {
                    firstClicked = 11;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 11) {
                                int list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 12;

                if (buttonsClicked == 1) {
                    firstClicked = 12;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 12) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 13, 14, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 13;

                if (buttonsClicked == 1) {
                    firstClicked = 13;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 13) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15 ,16 ,17, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 14;

                if (buttonsClicked == 1) {
                    firstClicked = 14;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 14) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15 ,16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 15;

                if (buttonsClicked == 1) {
                    firstClicked = 15;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 15) {
                                int list[] = {0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 16 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 16;

                if (buttonsClicked == 1) {
                    firstClicked = 16;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 16) {
                                int list[] = {0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ,17, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 17;

                if (buttonsClicked == 1) {
                    firstClicked = 17;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 17) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15 ,16, 18, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 18;

                if (buttonsClicked == 1) {
                    firstClicked = 18;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 18) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15 ,16 ,17, 19};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));

                }
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonsClicked == 0) {
                    carDoor = 0 + (int)(Math.random() * 20);
                }
                buttonsClicked++;
                buttonClicked = 19;

                if (buttonsClicked == 1) {
                    firstClicked = 19;
                    //sets one wrong door to open.
                    for (int x = 0; x <= 19; x++) {
                        if (x != firstClicked && x != carDoor) {
                            if (carDoor == 19) {
                                int list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15 ,16 ,17, 18};
                                for (int y = 0; y <= 17; y++){
                                    buttons[list[y]].setImageResource(R.drawable.goatdoor);
                                    buttons[list[y]].setClickable(false);
                                }
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
                    for (int x = 0; x <= 19; x++){
                        if (carDoor != x){
                            buttons[x].setImageResource(R.drawable.goatdoor);
                        }
                    }
                    statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                    statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));
                }
            }
        });

        reset2.setOnClickListener(new View.OnClickListener() {
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
                statsStayed2.setText("Games stayed : " + d2.format(stayed) + "\n" + "Games stayed and won : " + d2.format(stayedAndWon) + "\n" + "Probability to win : " + d.format(stayedAndWon / stayed * 100));
                statsSwitched2.setText("Games switched : " + d2.format(switched) + "\n" + "Games switched and won : " + d2.format(switchedAndWon) + "\n" + "Probability to win : " + d.format(switchedAndWon / switched * 100));
                for (int x = 0; x <= 19; x++) {
                    buttons[x].setImageResource(R.drawable.closeddoor);
                    buttons[x].setClickable(true);
                }
            }
        });

        goAgain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isWon = false;
                openDoor = false;
                buttonClicked = -1;
                firstClicked = -1;
                buttonsClicked = 0;
                for (int x = 0; x <= 19; x++) {
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
