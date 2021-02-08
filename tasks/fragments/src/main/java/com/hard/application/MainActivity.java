package com.hard.application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hard.application.fragments.Fragment1;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = Fragment1.newInstance("", "");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment1, null)
                .commit();
    }
}