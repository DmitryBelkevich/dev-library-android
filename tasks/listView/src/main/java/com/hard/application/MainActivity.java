package com.hard.application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Collection<Model> models = new ArrayList<>();

    public MainActivity() {
        for (int i = 1; i <= 100; i++)
            models.add(new Model(i));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ModelActivity.class);

                Model model = (Model) parent.getAdapter().getItem(position);

                Bundle bundle = new Bundle();
                bundle.putLong("id", model.getId());
                bundle.putString("title", model.getTitle());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ArrayAdapter<Model> arrayAdapter = new MyAdapter(this, R.layout.list_item, (List<Model>) models);
        listView.setAdapter(arrayAdapter);
    }

    private class MyAdapter extends ArrayAdapter<Model> {
        private Context context;
        private int resource;

        public MyAdapter(@NonNull Context context, int resource, @NonNull List<Model> objects) {
            super(context, resource, objects);

            this.context = context;
            this.resource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            convertView = layoutInflater.inflate(resource, parent, false);

            Model model = getItem(position);

            // icons

            ImageView icon_imageView = convertView.findViewById(R.id.icon);
            icon_imageView.setImageResource(R.drawable.ic_launcher_foreground);

            // fields

            TextView id_textView = convertView.findViewById(R.id.id);
            id_textView.setText(String.valueOf(model.getId()));

            TextView title_textView = convertView.findViewById(R.id.title);
            title_textView.setText(model.getTitle());

            return convertView;
        }
    }
}