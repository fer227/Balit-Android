package com.app.balit.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static String getUrlBase(){
        return "http://localhost:6000/";
    }

    public static void enviarToast(String msg, Context context){
        //Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = null;
        toast = Toast.makeText(context, msg, duration);
        toast.show();
    }
}
