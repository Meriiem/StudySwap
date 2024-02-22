package com.example.studyswap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MyNotesFragment extends Fragment {

    private static ArrayList<Item> notes;
    private ListView list;
    private static ItemAdapter adapter;

    public MyNotesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        notes = new ArrayList<>();
        notes.add(new Item("Integration notes", "Calculus 1", "2020", R.drawable.calc_notes_1, "NOTES", "FREE", "Paper"));
        notes.add(new Item("Linear Algebra", "Intro to CS", "2019", R.drawable.calc_notes_2, "NOTES", "55AED", "Paper"));

        adapter = new ItemAdapter(getContext(), notes);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_notes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        list = view.findViewById(R.id.listViewMyNotes);
        list.setAdapter(adapter);
    }//end of onViewCreated

    public static void AddNote(Item item){
        notes.add(item);
        adapter.notifyDataSetChanged();
    }
}