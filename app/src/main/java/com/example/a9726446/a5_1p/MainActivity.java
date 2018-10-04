package com.example.a9726446.a5_1p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_BOOKS = 20;
    private final List<Book> bookList = new ArrayList<>();
    private BookAdapter bookAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initaliseUI();
        populateBookData();

    }

    private void initaliseUI() {
        RecyclerView recyclerView = findViewById(R.id.rvBookList);

        //Documentation says this boosts performance if each item is the same size so...
        recyclerView.setHasFixedSize(true);

        //Set adapter
        bookAdapter = new BookAdapter(bookList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerView.setAdapter(bookAdapter);
    }

    /**
     * A method to PROCEDURALLY GENERATE books! How bleeding edge!
     */
    private void populateBookData() {
        //I wanted to give something interesting to look at.
        String variety[] = {"nice", "fairly okay", "pretty good", "excellent"};
        int j;
        for (int i = 0; i < NUM_BOOKS; i += 1) {
            j = i;
            while (j >= variety.length) j -= variety.length;
            //I acknowledge that the last parameter isn't secure, but what the hey it works in small doses.
            bookList.add(new Book(
                    "A Looping Story, Volume " + (i+1),
                    (i+2) + " Critics Agree: This is a " + variety[j] + " book.",
                    i+R.color.colorPrimary
                    ));
        }
        bookAdapter.notifyDataSetChanged();
    }
}