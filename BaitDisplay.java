package com.example.dakotahnorman.fishingtextbook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BaitDisplay extends Activity {

    private SQLiteDatabase db;
    private Cursor Lure_conditions_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bait_display);
        FishingPlan inputs = new FishingPlan();
        String input_temp = inputs.getWaterTempInput();
        String input_clarity = inputs.getWaterClarityInput();
        String input_structures = inputs.getStructureInput();
        String input_clouds = inputs.getCloudInput();
        String input_wind = inputs.getWindInput();
        String[] input_array = {input_temp, input_clarity, input_clouds, input_structures, input_wind};

        try{
            SQLiteOpenHelper fishingPlanDatabaseHelper = new FishingTextbookDatabaseHelper(this);
            db = fishingPlanDatabaseHelper.getReadableDatabase();
            //Create the cursor
            Lure_conditions_cursor = db.query("LURE CONDITIONS", new String[] {"NAME", "CONDITIONS"},
                        "_id = ?",new String[] {input_temp, input_clarity, input_clouds,
                            input_structures, input_wind}
                            ,null,null,null);
            if (Lure_conditions_cursor.moveToFirst()) {
                //Get drink details from cursor
                String nameText = Lure_conditions_cursor.getString(0);
                String descriptionText = Lure_conditions_cursor.getString(1);
                int photoId = Lure_conditions_cursor.getInt(2);

                //Populate the drink name
//                TextView name = (TextView) findViewById(R.id.name);
//                name.setText(nameText);

                //Populate the drink description
//                TextView description = (TextView) findViewById(R.id.description);
//                description.setText(descriptionText);

                //Populate the drink image
                ImageView photo = (ImageView) findViewById(R.id.first_pic);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }

            Log.d("query********", Lure_conditions_cursor.toString());
        } catch (SQLiteException e)
        {
            //Display if database doesn't work
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
