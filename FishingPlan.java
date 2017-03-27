package com.example.dakotahnorman.fishingtextbook;

/**
 * Created by Dakotah Norman on 11/6/2016.
 * Sets up the spinners for the Fishing Plan display page.
 * Also saves the inputs from that page to be used in the Bait display queries.
 */

import android.support.v4.app.TaskStackBuilder;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;



public class FishingPlan extends Activity
{
    //Set up variables for the spinners and the input of the spinners
    Spinner water_temp_spinner;
    public static String water_temp_input;
    Spinner structure_spinner;
    public static String structure_input;
    Spinner cloud_spinner;
    public static String cloud_input;
    Spinner wind_spinner;
    public static String wind_input;
    Spinner water_clarity_spinner;
    public static String water_clarity_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fishing_plan_interface);
        //Set up the button
        Button btn = (Button) findViewById(R.id.plan_button);
        //Listen for the button click
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Saves the inputs from the spinners
                //Water spinner and input
                water_temp_spinner = (Spinner) findViewById(R.id.water_temp);
                water_temp_input = water_temp_spinner.getSelectedItem().toString();
                //Structure spinner and input
                structure_spinner = (Spinner) findViewById(R.id.structures);
                structure_input = structure_spinner.getSelectedItem().toString();
                //Cloud spinner and input
                cloud_spinner = (Spinner) findViewById(R.id.clouds);
                cloud_input = cloud_spinner.getSelectedItem().toString();
                //Wind spinner and input
                wind_spinner = (Spinner) findViewById(R.id.wind);
                wind_input = wind_spinner.getSelectedItem().toString();
                //Water clarity spinner and input
                water_clarity_spinner = (Spinner) findViewById(R.id.water_clarity);
                water_clarity_input = water_clarity_spinner.getSelectedItem().toString();
//                Log.d("input****",water_temp_input);
//                Log.d("input****",structure_input);
//                Log.d("input****",cloud_input);
//                Log.d("input****",wind_input);
//                Log.d("input****",water_clarity_input);
                //After saving the inputs, start the BaitDisplay activity.
                startActivity(new Intent(FishingPlan.this, BaitDisplay.class));
            }

            });
        //Call the set spinners method
        setSpinners();
    }
    //Sets the Spinners with their respective values.
    public void setSpinners()
    {
        //Water temp spinner
        Spinner water_temp_spinner = (Spinner) findViewById(R.id.water_temp);
        ArrayAdapter<CharSequence> water_temp_adapter = ArrayAdapter.createFromResource(this, R.array.water_temp_choices,
                android.R.layout.simple_spinner_dropdown_item);
        water_temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_temp_spinner.setAdapter(water_temp_adapter);
        //Structures spinner
        Spinner structures_spinner = (Spinner) findViewById(R.id.structures);
        ArrayAdapter<CharSequence> structures_adapter = ArrayAdapter.createFromResource(this, R.array.structure_choices,
                android.R.layout.simple_spinner_dropdown_item);
        structures_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        structures_spinner.setAdapter(structures_adapter);
        //Clouds spinner
        Spinner cloud_spinner = (Spinner) findViewById(R.id.clouds);
        ArrayAdapter<CharSequence> cloud_adapter = ArrayAdapter.createFromResource(this,R.array.cloud_choices,
                android.R.layout.simple_spinner_dropdown_item);
        cloud_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cloud_spinner.setAdapter(cloud_adapter);
        //Wind spinner
        Spinner wind_spinner = (Spinner) findViewById(R.id.wind);
        ArrayAdapter<CharSequence> wind_adapter = ArrayAdapter.createFromResource(this,R.array.wind_choices,
                android.R.layout.simple_spinner_dropdown_item);
        wind_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wind_spinner.setAdapter(wind_adapter);
        //Water Clarity spinner
        Spinner water_clarity_spinner = (Spinner) findViewById(R.id.water_clarity);
        ArrayAdapter<CharSequence> water_clarity_adapter = ArrayAdapter.createFromResource(this, R.array.water_clarity_choices,
                android.R.layout.simple_spinner_dropdown_item);
        water_clarity_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_clarity_spinner.setAdapter(water_clarity_adapter);
    }
    //Saves the water clarity input to be passed to the BaitDisplay activity
    public String getWaterClarityInput()
    {
        return this.water_clarity_input;
    }
    //Saves the water temp input to be passed to the BaitDisplay activity
    public String getWaterTempInput()
{
    return this.water_temp_input;
}
    //Saves the cloud input to be passed to the BaitDisplay activity
    public String getCloudInput()
    {
        return this.cloud_input;
    }
    //Saves the structure input to be passed to the BaitDisplay activity
    public String getStructureInput()
    {
        return this.structure_input;
    }
    //Saves the wind input to be passed to the BaitDisplay activity
    public String getWindInput()
    {
        return this.wind_input;
    }

}
