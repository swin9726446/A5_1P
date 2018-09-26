package com.example.a9726446.a5_1p;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 9726446 on 26/9/18 @ LB1-MAC-009
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private final List<Book> bookList;

    static class BookViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView rating;
        final ImageView icon;

        private BookViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tvTitle);
            rating = view.findViewById(R.id.tvRating);
            icon = view.findViewById(R.id.ivIcon);
        }
    }

    BookAdapter(List<Book> bookList){
        this.bookList = bookList;
    }

    //Create
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //New item
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row, parent, false);
        return new BookViewHolder(itemView);
    }

    //Replace
    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position){
        //get element
        //replace contents
        Book book = bookList.get(position);
        holder.title.setText(book.getTitle());
        holder.rating.setText(book.getRating());
        holder.icon.setImageResource(book.getIcon());
    }

    //return size
    @Override
    public int getItemCount(){
        return bookList.size();
    }
}