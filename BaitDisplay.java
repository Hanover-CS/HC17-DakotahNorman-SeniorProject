package com.example.dakotahnorman.fishingtextbook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class BaitDisplay extends Activity {

    Cursor cursor;
    Cursor conditions_cursor;
    String input_temp, input_clarity, input_structures, input_clouds, input_wind;
    String nameText, descriptionText;
    TextView name, description;
    ImageView picView;
    int picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bait_display);



        input_temp = FishingPlan.water_temp_input;
        input_clarity = FishingPlan.water_clarity_input;
        input_structures = FishingPlan.structure_input;
        input_clouds = FishingPlan.cloud_input;
        input_wind = FishingPlan.wind_input;
        //String[] input_array = {input_temp, input_clarity, input_clouds, input_structures, input_wind};
        Log.i("input****", input_temp);
        //Log.d("input****",input_temp);
        try{
            SQLiteOpenHelper FishingPlanDatabaseHelper = new NewDatabaseThing(this);
            Log.i("name**","here");
            SQLiteDatabase db = FishingPlanDatabaseHelper.getWritableDatabase();
            //Create the cursor
            //First set of info
            Cursor cursor = db.query("LURES", new String[] {"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
                    "NAME = 'Jig'",null,null,null,null);
            accessCursor(cursor);
            //Populate the Display fields
            name = (TextView) findViewById(R.id.first_name);
            name.setText(nameText);
            description = (TextView) findViewById(R.id.first_description);
            description.setText(descriptionText);
            picView = (ImageView) findViewById(R.id.first_pic);
            picView.setImageResource(picture);

            cursor.close();
            //2nd set of text and picture
            Cursor cursor2 = db.query("LURES", new String[] {"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
                    "NAME = 'Frog'",null,null,null,null);
            accessCursor(cursor2);
            //Populate the Display fields
            name = (TextView) findViewById(R.id.second_name);
            name.setText(nameText);
            description = (TextView) findViewById(R.id.second_description);
            description.setText(descriptionText);
            picView = (ImageView) findViewById(R.id.second_pic);
            picView.setImageResource(picture);

            cursor2.close();
            //3rd set of info
            Cursor cursor3 = db.query("LURES", new String[] {"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
                    "NAME = 'Soft Plastic Swimbait'",null,null,null,null);
            accessCursor(cursor3);
            //Populate the Display fields
            name = (TextView) findViewById(R.id.third_name);
            name.setText(nameText);
            description = (TextView) findViewById(R.id.third_description);
            description.setText(descriptionText);
            picView = (ImageView) findViewById(R.id.third_pic);
            picView.setImageResource(picture);

            cursor3.close();
            db.close();
            //Log.d("query********", Lure_conditions_cursor.toString());
        } catch (SQLiteException e)
        {
            //Display if database doesn't work
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void accessCursor(Cursor cursor)
    {
        if (cursor.moveToFirst()) {

            //Get details from the cursor
            nameText = cursor.getString(0);
            descriptionText = cursor.getString(1);
            picture = cursor.getInt(2);

        }
    }

}
