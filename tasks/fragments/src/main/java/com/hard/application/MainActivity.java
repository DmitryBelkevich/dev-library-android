package com.hard.application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hard.application.fragments.Fragment1;
import com.hard.application.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = Fragment1.newInstance("", "");
        Fragment2 fragment2 = Fragment2.newInstance("", "");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragment1, null)
                .add(R.id.container_layout, fragment2, null)
                .commit();
    }
}