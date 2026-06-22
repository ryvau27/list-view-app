package com.example.listviewapp;

import java.io.Serializable;

/*
 * class representing an item displayed in the ListView.
 *
 * Serializable allows this object to be converted into a format
 * that Android can transfer between Activities using an Intent.
 */
public class Item implements Serializable {

    // stores the title
    private String title;

    // stores the subtitle
    private String subtitle;


    /*
     * Constructor
     *
     * @param title The item name
     * @param subtitle Additional information about the item
     */
    public Item(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    // title getter
    public String getTitle() {
        return title;
    }

    // subtitle getter
    public String getSubtitle() {
        return subtitle;
    }
}
