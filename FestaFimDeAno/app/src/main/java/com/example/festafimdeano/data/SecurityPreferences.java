package com.example.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    private SharedPreferences mSharedPreferences;


    public SecurityPreferences(Context mContext){
        this.mSharedPreferences = mContext.getSharedPreferences("EndYearsParty", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key){

        return this.mSharedPreferences.getString(key, "");
    }
}
