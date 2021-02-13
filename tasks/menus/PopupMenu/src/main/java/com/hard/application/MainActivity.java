package com.hard.application;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);

                // xml
                popupMenu.inflate(R.menu.menu);

                // programmatically
                Menu menu = popupMenu.getMenu();
                menu.add(1, R.id.item_2, 1, "item 2");

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        switch (id) {
                            case R.id.item_1:
                                // TODO
                                return true;
                            case R.id.item_2:
                                // TODO
                                return true;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }
}