package com.example.dakotahnorman.fishingtextbook;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

/**
 * Created by Dakotah Norman on 1/20/2017.
 * Implements the database that is used in the BaitDisplay activity.
 */
public class NewDatabaseThing extends SQLiteOpenHelper
{
    private static final String DB_NAME = "fishing_textbook2"; //Name of database
    private static final int DB_VERSION = 1; //version of database;

    NewDatabaseThing(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1)
        {
            //Creates the Lures table
            db.execSQL("CREATE TABLE LURES ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID TEXT);");
            //Populate the Lures table
            insertLures(db, "Jig", "This lure is used by either 'swimming' the bait back to you at a steady retrieve or" +
                    " by slowly dragging or hopping the bait across the bottom of the lake/pond. Typically paired with a crawfish " +
                    "as a trailer. Any similar trailers can be used.", R.drawable.jig);
            insertLures(db, "Jerkbait", "This lure is used by either 'swimming' the bait back to you at a steady retrieve" +
                    " or by quickly jerking the rod tip to the side with tension on the line. This creates an eratic movement that" +
                    " bass want", R.drawable.jerkbait);
            insertLures(db, "Frog", "This lure is a topwater lure. It is used by 'walking' the bait by rhythmically twitching the rod tip to " +
                    "the side.", R.drawable.frog);
            insertLures(db, "Soft Plastic Swimbait", "This lure is used by simply casting out, letting the bait sink to the desired depth " +
                    "and reeling in at a steady or eractic pace.", R.drawable.plastic_swimbait);
            insertLures(db, "Lipless Crankbait", "This lure is used by casting out and retrieving the bait. You can either stop-and-go reel " +
                    "or you can use a steady retrieve.", R.drawable.lipless_crank);
            insertLures(db, "Spinnerbait", "This lure is used by casting out and retrieving the bait. Use a steady retrieve.", R.drawable.spinnerbait);
            //Creates the Lureconditions table
            db.execSQL("CREATE TABLE LURECONDITIONS ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "CONDITIONS TEXT);");
            //Populate the Lure Conditions table
            insertLureConditions(db, "Jig", "Rock");
            insertLureConditions(db, "Jig", "Submerged Timber");
            insertLureConditions(db, "Jig", "40-49");
            insertLureConditions(db, "Jig", "50-59");
            insertLureConditions(db, "Jig", "60-69");
            insertLureConditions(db, "Jig", "70-79");
            insertLureConditions(db, "Jig", "80-89");
            insertLureConditions(db, "Spinnerbait", "Wind");
            insertLureConditions(db, "Spinnerbait", "Complete cloud cover");
            insertLureConditions(db, "Spinnerbait", "Slight cloud cover");
            insertLureConditions(db, "Spinnerbait", "70-79");
            insertLureConditions(db, "Spinnerbait", "No structure");
            insertLureConditions(db, "Spinnerbait", "Stained");
            insertLureConditions(db, "Spinnerbait", "Murky");
            insertLureConditions(db, "Jerkbait", "No structure");
            insertLureConditions(db, "Jerkbait", "50-59");
            insertLureConditions(db, "Jerkbait", "60-69");
            insertLureConditions(db, "Jerkbait", "Clear");
            insertLureConditions(db, "Lipless Crankbait", "70-79");
            insertLureConditions(db, "Lipless Crankbait", "No Structure");
            insertLureConditions(db, "Lipless Crankbait", "Submerged grass");
            insertLureConditions(db, "Lipless Crankbait", "Rock");
            insertLureConditions(db, "Lipless Crankbait", "Stained");
            insertLureConditions(db, "Lipless Crankbait", "Clear");
        }
    }
    //Method to insert into the Lures table.
    private static void insertLures(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues lureValues = new ContentValues();
        lureValues.put("NAME", name);
        lureValues.put("DESCRIPTION", description);
        lureValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("LURES", null, lureValues);
    }
    //Method to insert into the Lure Conditions.
    private static void insertLureConditions(SQLiteDatabase db, String lure_name, String conditions)
    {
        ContentValues inputLureConditions = new ContentValues();
        inputLureConditions.put("NAME", lure_name);
        inputLureConditions.put("CONDITIONS", conditions);
        db.insert("LURECONDITIONS", null, inputLureConditions);
    }


}
