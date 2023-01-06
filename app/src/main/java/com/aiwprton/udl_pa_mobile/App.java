package com.aiwprton.udl_pa_mobile;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;

public class App extends Application {
    public static String DomenIp = "xn--j1ab.xn--d1aadjija0bkk2khl.xn--p1ai";
    public static String DomenUri = "https://" + DomenIp;
    public static String ApiDomenUri = DomenUri + "/api/";
    public static SharedPreferences pref;
    public static SharedPreferences.Editor prefEditor;

    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    @Override
    public void onCreate() {
        super.onCreate();

        pref = getDefaultSharedPreferences(this);
        prefEditor = pref.edit();
    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
