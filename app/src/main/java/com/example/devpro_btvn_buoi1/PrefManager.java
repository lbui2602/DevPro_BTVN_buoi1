package com.example.devpro_btvn_buoi1;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    public static final String SHEF_NAME="Android53";
    public static void saveString(Context context, String key, String value){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHEF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public static String getString(Context context, String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHEF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,null);
    }
    public static void removeKey(Context context,String key){
        SharedPreferences sharedPreferences =context.getSharedPreferences(SHEF_NAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();
    }
}
