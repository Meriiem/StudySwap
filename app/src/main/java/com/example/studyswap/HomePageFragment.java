package com.example.studyswap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageFragment extends Fragment {

    private static final String ARG_SHOW_FOR_MAJOR = "show_for_major";
    private RecyclerView materialsRecyclerView;
    private CourseMaterialAdapter adapter;
    private List<CourseMaterial> originalCourseMaterials;
    private boolean showForMajor;

    public static HomePageFragment newInstance(boolean showForMajor) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_SHOW_FOR_MAJOR, showForMajor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            showForMajor = getArguments().getBoolean(ARG_SHOW_FOR_MAJOR);
        }

        // Fetch the global list of course materials
        originalCourseMaterials = new ArrayList<>(StudySwapApplication.getCourseMaterials());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        materialsRecyclerView = view.findViewById(R.id.materialsRecyclerView);
        materialsRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        // Set up the adapter with the list and click listener
        adapter = new CourseMaterialAdapter(getFilteredCourseMaterials(), getContext(), courseMaterial -> {
            // When an item is clicked, open the CourseMaterialDetailActivity with the selected course material
            Intent detailIntent = new Intent(getContext(), CourseMaterialDetailActivity.class);
            detailIntent.putExtra("EXTRA_COURSE_MATERIAL", courseMaterial); // Make sure CourseMaterial implements Serializable
            startActivity(detailIntent);
        });

        materialsRecyclerView.setAdapter(adapter);
        return view;
    }

    public void filterContent(String searchQuery, String selectedFilter) {
        List<CourseMaterial> filteredList;

        // Perform filtering based on search query and selected filter
        filteredList = originalCourseMaterials.stream()
                .filter(material -> matchesFilter(material, searchQuery, selectedFilter))
                .collect(Collectors.toList());

        if (showForMajor) {
            // Filter the list further by the user's major if necessary
            String userMajor = PreferencesManager.getUserMajor(getContext());
            filteredList = filteredList.stream()
                    .filter(material -> material.getMajor().equalsIgnoreCase(userMajor))
                    .collect(Collectors.toList());
        }

        // Update the adapter with the filtered list
        adapter.updateCourseMaterials(filteredList);
    }

    private boolean matchesFilter(CourseMaterial material, String searchTerm, String selectedFilter) {
        switch (selectedFilter) {
            case "Course Name":
                return material.getCourseName().toLowerCase().contains(searchTerm.toLowerCase());
            case "Virtual or Printed":
                return material.getVirtualOrPrinted().toLowerCase().contains(searchTerm.toLowerCase());
            case "Year of Publication":
                return material.getYear().equals(searchTerm);
            case "Major":
                return material.getMajor().equalsIgnoreCase(searchTerm);
            case "Paid or Free":
                return material.getPaidOrFree().equalsIgnoreCase(searchTerm);
            // Add more cases as needed
        }
        return false;
    }

    private List<CourseMaterial> getFilteredCourseMaterials() {
        if (showForMajor) {
            // Filter the list by the user's major
            String userMajor = PreferencesManager.getUserMajor(getContext());
            return originalCourseMaterials.stream()
                    .filter(material -> material.getMajor().equalsIgnoreCase(userMajor))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>(originalCourseMaterials); // Return a copy of the original list
        }
    }
}