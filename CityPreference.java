package com.example.dakotahnorman.fishingtextbook;

/**
 * Created by Dakotah Norman on 3/13/2017.
 * Sets the default city value for the WeatherFragment.
 */
import android.app.Activity;
import android.content.SharedPreferences;

public class CityPreference {

    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Hanover as the default city
    String getCity(){
        return prefs.getString("city", "Hanover, US");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }

}