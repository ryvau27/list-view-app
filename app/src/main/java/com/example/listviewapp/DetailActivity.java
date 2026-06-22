package com.example.listviewapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/*
 * Detail Activity:
 *
 * displays information about the item selected
 * from the MainActivity ListView.
 */
public class DetailActivity extends AppCompatActivity {


    TextView title;
    TextView subtitle;



    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        // loads detail screen layout
        setContentView(R.layout.activity_detail);

        title =
                findViewById(R.id.detailTitle);

        subtitle =
                findViewById(R.id.detailSubtitle);


        /*
         * receive the Item object sent from MainActivity.
         *
         * Serializable allows Android to transfer
         * the complete object through the Intent.
         */
        Item item =
                (Item)getIntent()
                        .getSerializableExtra("item");

        if(item != null){

            title.setText(item.getTitle());

            subtitle.setText(item.getSubtitle());

        }

    }

}
