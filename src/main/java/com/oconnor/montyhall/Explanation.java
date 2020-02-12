package com.oconnor.montyhall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class Explanation extends AppCompatActivity {

    private TextView explanation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        explanation = (TextView) findViewById(R.id.explanation);

        explanation.setText("\t\t\tThe Monty Problem is a very famous math problem that is loosely based around a game show hosted by an individual known as Monty Hall a Canadian game show host for a game called 'Let's Make a Deal'.\n\n\t\t\tIn the game the player gets to choose 1 door from 3 doors.  Behind 1 of the doors is a car and behind all the others is goats in the case of the show there would be 2 goats and 1 car.  The player chooses 1 of the doors while they are closed having no prior knowledge of what door has the car or goats.  After the player chooses a door the host will choose 1 door that is not yours and is not the door with the car, the host will open the door revealing more information about what door has the car.  The player then has the option to stick with their door or switch.  Do you switch or do you stay?\n\n\t\t\tThe answer surprises a lot of people because they originally think the odds are a 50% chance of winning when in reality if you switch you have a 2/3 chance or 66.66% repeating chance.  From what originally is a 1/3 chance of being a winner now goes up to 2/3 chance of wining because their is more information being presented.\n\n\t\t\tI have created two games one that has 3 doors and one that has 20 doors.  In the 3 door version the host chooses 1 door.  In the 20 door version the host chooses 18 wrong doors allowing for people to better visualize and understand why switching is a higher chance and increasing their knowledge of how probability works.\n\nFurther Explanation:\n\n\t\t\tWhen you are first choosing your door you are picking from 3 doors, thus the 1/3 chance since only 1 door is correct, but after you choose your first door the host reveals 1 wrong door and never a correct door pushing the original 1/3 chance of being right to 2/3 if you switch.\n\n\t\t\tAnother way to understand the probability is that 1/3 of the time you are choosing correct on your first pick, but 2/3 of the time you are picking wrong, thus when the a door is revealed the chance of being right when switching are now 2/3.  Now if there are 20 doors, 18 doors are revealed in this case making it a 1/20 chance of being correct on your first pick and 19/20 chance of being wrong on your first pick.  The reveal of the wrong doors makes the chance of being correct if you switch a 19/20 or 95% chance.  The more doors that are added only increases your chance of being right when you switch.\n\nIf You Switch:\n\n1: You pick correct, switch, you lose.\n2: You pick wrong, switch, you win.\n3: You pick wrong, switch, you win.\n\nIf You Stay:\n\n4: You pick correct, stay, you win.\n5: You pick wrong, stay, you lose\n6: You pick wrong, stay, you lose.");
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
