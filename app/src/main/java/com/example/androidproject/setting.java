package com.example.androidproject;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class setting extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}