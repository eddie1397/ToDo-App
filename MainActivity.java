package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;

    Button btnAdd;
    EditText etItem;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        etItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);

        items = new ArrayList<>();
        items.add("Go to Target");
        items.add("Practice Guitar");
        items.add("Make a grocery list!");
        items.add("Prep Dinner");
        items.add("Dance like nobody's watching!");

        ItemsAdapter itemsAdapter = new ItemsAdapter(items);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoItem = etItem.getText().toString();
                //Add this new item to the model
                items.add(todoItem);
                // Notify the adapter that we have inserted an item
                itemsAdapter.notifyItemInserted(items.size()-1);
                etItem.setText("");
                Toast.makeText(getApplicationContext(), "Your item has been added! :)", Toast.LENGTH_SHORT).show();

                //For some reason when I tried to import the commons resource Android Studio would not allow me to add it. Hopefully you enjoy my app!
                // :)
            }
        });
    }
}