package com.example.dakotahnorman.fishingtextbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Interface extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__interface);
        Button btn = (Button) findViewById(R.id.fishing_plan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main_Interface.this, FishingPlan.class));
            }

        });
        Button weatherButton = (Button) findViewById(R.id.weather);
        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main_Interface.this, WeatherDisplay.class));
            }
        });
        Button mapButton = (Button) findViewById(R.id.map);
        mapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main_Interface.this, MapsActivity.class));
            }
        });
    }

}
