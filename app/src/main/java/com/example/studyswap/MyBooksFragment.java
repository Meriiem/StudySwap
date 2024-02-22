package com.example.studyswap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MyBooksFragment extends Fragment {

    private static ArrayList<Item> books;
    private ListView list;
    private static ItemAdapter adapter;

    public MyBooksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        books = new ArrayList<>();
        books.add(new Item("Intro to Algorithms", "Algorithms", "2017", R.drawable.algorithms_book, "BOOK", "40AED", "Virtual"));
        books.add(new Item("Computer Science Illuminated", "Intro to CS", "2015", R.drawable.computer_science_illuminated, "BOOK", "55AED", "Paper"));

        adapter = new ItemAdapter(getContext(), books);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_books, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        list = view.findViewById(R.id.listViewMyBooks);
        list.setAdapter(adapter);
    }//end of onViewCreated

    public static void AddBook(Item item){

        books.add(item);
        adapter.notifyDataSetChanged();
    }
}