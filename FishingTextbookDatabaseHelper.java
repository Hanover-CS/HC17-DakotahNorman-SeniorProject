package com.example.dakotahnorman.fishingtextbook;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Dakotah Norman on 10/24/2016.
 */
class FishingTextbookDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "fishing_textbook"; //Name of database
    private static final int DB_VERSION = 2; //version of database;

    FishingTextbookDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if(oldVersion == 1)
        {
            db.execSQL("CREATE TABLE LURES ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "USEFUL CONDITIONS TEXT, "
                    + "IMAGE_RESOURCE_ID_INTEGER);");
            //Populate the Lures table
            insertLure(db, "Jig", "This lure is used by either 'swimming' the bait back to you at a steady retrieve or" +
                    " by slowly dragging or hopping the bait across the bottom of the lake/pond. Typically paired with a crawfish " +
                    "as a trailer. Any similar trailers can be used.", "Useful in most conditions." +
                    " Especially in situations where structure is prevalent. Does not do well in grass.", R.drawable.jig);
            insertLure(db, "Jerkbait", "This lure is used by either 'swimming' the bait back to you at a steady retrieve" +
                            " or by quickly jerking the rod tip to the side with tension on the line. This creates an eratic movement that" +
                            " bass want", "Useful in water that is free of or has limited structure. Best used in stained to clear water.",
                    R.drawable.jerkbait);
            insertLure(db, "Frog", "This lure is a topwater lure. It is used by 'walking' the bait by rhythmically twitching the rod tip to " +
                            "the side.","Useful for fishing mats of grass on the top of the water or water that has a lot of submerged grass",
                    R.drawable.frog);
            insertLure(db, "Soft Plastic Swimbait", "This lure is used by simply casting out, letting the bait sink to the desired depth " +
                    "and reeling in at a steady or eractic pace.", "Useful in clear to stained water. Can be used in situations with lots " +
                    "of structue or little structure.", R.drawable.plastic_swimbait);
            insertLure(db, "Lipless Crankbait", "This lure is used by casting out and retrieving the bait. You can either stop-and-go reel " +
                    "or you can use a steady retrieve.", "Useful in conditions with grass and most water conditions.", R.drawable.lipless_crank);
            insertLure(db, "Spinnerbait", "This lure is used by casting out and retrieving the bait. Use a steady retrieve.", "Useful.", +
                    R.drawable.spinnerbait);

            db.execSQL("CREATE TABLE FISHING PLAN INPUTS ( "
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "AIR TEMP TEXT, "
                    + "WATER TEMP TEXT, "
                    + "WATER CLARITY TEXT, "
                    + "TYPE OF STRUCTURE TEXT, "
                    + "CLOUD COVER TEXT, "
                    + "WIND TEXT);");
            insertInput(db,"Jig","30-50","40-55","Clear","Rocks","None","No");
            insertInput(db,"Jig","30-50","40-55","Clear","Rocks","None","Yes");
            insertInput(db,"Jig","30-50","40-55","Clear","Submerged Timber","None","Yes");
            insertInput(db,"Jig","30-50","40-55","Clear","Rocks","Mild","No");
            insertInput(db,"Jig","30-50","40-55","Clear","Rocks","Complete Cover","No");
            insertInput(db,"Jig","30-50","40-55","Clear","Rocks","Mild","Yes");
            insertInput(db,"Jig","30-50","40-55","Clear","Rocks","Complete Cover","Yes");

        }
        if (oldVersion < 2)
        {
            db.execSQL("ALTER TABLE LURES DELETE COLUMN USEFUL CONDITIONS;");
            db.execSQL("DROP TABLE FISHING PLAN INPUTS;");
            db.execSQL("CREATE TABLE LURE CONDITIONS ( "
                        + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "NAME TEXT, "
                        + "CONDITIONS TEXT);");
            //Populate the Lure Conditions table
            insertLureConditions(db, "Jig", "Rock");
            insertLureConditions(db, "Jig", "Submerged Timber");
            insertLureConditions(db, "Jig", "50-60");
            insertLureConditions(db, "Jig", "60-70");
            insertLureConditions(db, "Jig", "70-80");
            insertLureConditions(db, "Jig", "80-90");
            insertLureConditions(db, "Spinnerbait", "Wind");
            insertLureConditions(db, "Spinnerbait", "Cloudy");
            insertLureConditions(db, "Spinnerbait", "70-80");
            insertLureConditions(db, "Spinnerbait", "No structure");
            insertLureConditions(db, "Spinnerbait", "Stained");
            insertLureConditions(db, "Spinnerbait", "Murky");
            insertLureConditions(db, "Jerkbait", "No structure");
            insertLureConditions(db, "Jerkbait", "50-60");
            insertLureConditions(db, "Jerkbait", "Clear");
            insertLureConditions(db, "Lipless Crankbait", "70-80");
            insertLureConditions(db, "Lipless Crankbait", "No Structure");
            insertLureConditions(db, "Lipless Crankbait", "Submerged grass");
            insertLureConditions(db, "Lipless Crankbait", "Rock");
            insertLureConditions(db, "Lipless Crankbait", "Stained");
            insertLureConditions(db, "Lipless Crankbait", "Clear");

            db.execSQL("CREATE TABLE CONDITIONS ( "
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "CONDITION NAME TEXT, "
                    + "CONDITION TYPE TEXT);");
            //Populate the Conditions table
            insertConditions(db, "Rock", "Structure");
            insertConditions(db, "Submerged Grass", "Structure");
            insertConditions(db, "Submerged Timber", "Structure");
            insertConditions(db, "Matted Grass", "Structure");
            insertConditions(db, "No Structure", "Structure");
            insertConditions(db, "Clear", "Water Clarity");
            insertConditions(db, "Stained", "Water Clarity");
            insertConditions(db, "Murky", "Water Clarity");
            insertConditions(db, "Slightly Cloudy", "Cloud Cover");
            insertConditions(db, "No Clouds", "Cloud Cover");
            insertConditions(db, "Very Cloudy", "Cloud Cover");
            insertConditions(db, "Windy", "Wind");
            insertConditions(db, "No Wind", "Wind");

            //Join the tables on name
            db.execSQL("LURES LEFT OUTER JOIN LURE CONDITIONS ON NAME");
            db.execSQL("LURE CONDITIONS LEFT OUTER JOIN CONDITIONS ON NAME");



        }
    }

    private static void insertLure(SQLiteDatabase db, String name, String description, String useful_conditions, int resourceId)
    {
        ContentValues lureValues = new ContentValues();
        lureValues.put("NAME", name);
        lureValues.put("DESCRIPTION", description);
        lureValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("LURE", null, lureValues);

    }

    private static void insertInput(SQLiteDatabase db, String name, String air_temp, String water_temp, String water_clarity, String structure,
                                    String cloud_cover, String wind)
    {
        ContentValues inputValues = new ContentValues();
        inputValues.put("NAME",name);
        inputValues.put("AIR TEMP",air_temp);
        inputValues.put("WATER TEMP",water_temp);
        inputValues.put("WATER CLARITY",water_clarity);
        inputValues.put("TYPE OF STRUCTURE",structure);
        inputValues.put("CLOUD COVER",cloud_cover);
        inputValues.put("WIND",wind);
        db.insert("FISHING PLAN INPUTS", null, inputValues);
    }

    private static void insertLureConditions(SQLiteDatabase db, String lure_name, String conditions)
    {
        ContentValues inputLureConditions = new ContentValues();
        inputLureConditions.put("LURE NAME", lure_name);
        inputLureConditions.put("CONDITIONS", conditions);
        db.insert("LURE CONDITIONS", null, inputLureConditions);
    }

    private static void insertConditions(SQLiteDatabase db, String condition_name, String condition_type)
    {
        ContentValues inputConditions = new ContentValues();
        inputConditions.put("CONDITION NAME", condition_name);
        inputConditions.put("CONDITION TYPE", condition_type);
        db.insert("CONDITIONS", null, inputConditions);
    }
}
