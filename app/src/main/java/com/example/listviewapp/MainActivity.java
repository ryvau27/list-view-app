package com.example.listviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/*
 * Main Activity:
 *
 * Responsible for:
 * - Creating the list of items
 * - Displaying items using ListView
 * - Handling user clicks
 * - Sending selected item data to DetailActivity
 */
public class MainActivity extends AppCompatActivity {


    // UI component displaying the collection of items
    ListView listView;

    // stores all objects displayed in the ListView
    ArrayList<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // loads the activity_main.xml layout
        setContentView(R.layout.activity_main);


        // connect ListView from XML
        listView = findViewById(R.id.listView);


        // create and add sample data
        items = new ArrayList<>();


        items.add(
                new Item(
                        "Android",
                        "Mobile operating system"
                )
        );


        items.add(
                new Item(
                        "Java",
                        "Programming language"
                )
        );


        items.add(
                new Item(
                        "GitHub",
                        "Code repository platform"
                )
        );


        /*
         * attach custom Adapter.
         *
         * the Adapter controls how each item
         * is displayed inside the ListView.
         */
        ItemAdapter adapter =
                new ItemAdapter(this, items);



        listView.setAdapter(adapter);


        /*
         * listener detects when an item is clicked.
         */
        listView.setOnItemClickListener(
                (parent, view, position, id) -> {


                    Item selectedItem =
                            items.get(position);


                    /*
                     * explicit Intent:
                     *
                     * specifies the Activity
                     * that should be opened.
                     */
                    Intent intent =
                            new Intent(
                                    MainActivity.this,
                                    DetailActivity.class
                            );

                    /*
                     * pass selected Item object
                     * to the next Activity.
                     */
                    intent.putExtra(
                            "item",
                            selectedItem
                    );


                    startActivity(intent);

                }
        );

    }

    /*
     * called when returning to MainActivity.
     *
     * displays confirmation that navigation completed.
     */
    @Override
    protected void onResume(){

        super.onResume();


        Toast.makeText(
                this,
                "Operation completed successfully",
                Toast.LENGTH_SHORT
        ).show();

    }

}
