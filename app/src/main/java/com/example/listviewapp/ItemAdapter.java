package com.example.listviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * Custom Adapter responsible for connecting the data model objects
 * to the ListView UI component.
 *
 */
public class ItemAdapter extends BaseAdapter {

    // allows access to application resources and layout
    private Context context;

    // stores the collection of item objects in the ListView
    private ArrayList<Item> itemList;


    /*
     * Constructor receives the Activity context and list data.
     */
    public ItemAdapter(Context context, ArrayList<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    /*
     * Returns the number of items in the ListView.
     */
    @Override
    public int getCount() {
        return itemList.size();
    }

    /*
     * Returns an item at a given position.
     */
    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    /*
     * Returns the unique ID of an item.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    /*
     * Creates each individual ListView row.
     *
     * This method is called for every item.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
         * Inflate the custom row layout that defines
         * how each item appears visually.
         */
        if(convertView == null){

            convertView = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_row, parent, false);
        }


        TextView title =
                convertView.findViewById(R.id.itemTitle);

        TextView subtitle =
                convertView.findViewById(R.id.itemSubtitle);



        Item item = itemList.get(position);


        title.setText(item.getTitle());

        subtitle.setText(item.getSubtitle());


        return convertView;
    }
}
