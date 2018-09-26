package com.example.a9726446.a5_1p;

/**
 * Created by 9726446 on 26/9/18 @ LB1-MAC-009
 */

class Book {
    //Private Variables:
    private final String title;
    private final String rating;
    private final int icon;

    //Getters:
    public String getTitle() {
        return title;
    }

    String getRating() {
        return rating;
    }

    public int getIcon() {
        return icon;
    }


    //Constructor:
    Book(String aTitle, String aRating, int anIcon){
        title = aTitle;
        rating = aRating;
        icon = anIcon;
    }
}
