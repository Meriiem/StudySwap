package com.example.studyswap;

import android.app.Application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudySwapApplication extends Application {

    private static List<CourseMaterial> courseMaterials;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the list with initial data
        courseMaterials = createMockData();
    }

    public static List<CourseMaterial> getCourseMaterials() {
        return new ArrayList<>(courseMaterials);
    }

    private List<CourseMaterial> createMockData() {
        return Arrays.asList(
                new CourseMaterial("Intro to Algorithms", "Computer Science", "2015", "CS101", "Free", "Virtual", R.drawable.algorithms_book),
                new CourseMaterial("Advanced Mathematics", "Mathematics", "2010", "MATH301", "Paid", "Printed", R.drawable.mathematics_book),
                new CourseMaterial("Economic Theory Slides", "Economics", "2021", "ECON201", "Free", "Virtual", R.drawable.economics_slides),
                new CourseMaterial("Organic Chemistry Notes", "Chemistry", "2023", "CHEM201", "Paid", "Printed", R.drawable.chemistry_notes),
                new CourseMaterial("European History Book", "History", "1985", "HIST102", "Free", "Virtual", R.drawable.history_book),
                new CourseMaterial("Basics of Drawing", "Art", "2004", "ART101", "Paid", "Printed", R.drawable.art_drawing),
                new CourseMaterial("Philosophical Essays", "Philosophy", "2019", "PHIL100", "Free", "Virtual", R.drawable.philosophy_essays),
                new CourseMaterial("Bacterial Pathogens Slides", "Biology", "2020", "BIO301", "Paid", "Printed", R.drawable.biology_slides),
                new CourseMaterial("Cognitive Psychology Case Studies", "Psychology", "2022", "PSY201", "Free", "Virtual", R.drawable.psychology_case_studies),
                new CourseMaterial("Electrical Engineering Experiments", "Engineering", "2007", "ENG233", "Paid", "Printed", R.drawable.engineering_experiments),
                new CourseMaterial("Political Analysis Papers", "Political Science", "2018", "POL101", "Paid", "Virtual", R.drawable.political_science_papers),
                new CourseMaterial("Quantum Physics Research", "Physics", "2012", "PHY204", "Free", "Printed", R.drawable.physics_research),
                new CourseMaterial("Shakespeare Plays Analysis", "English", "2017", "ENG401", "Paid", "Virtual", R.drawable.english_literature),
                new CourseMaterial("Calculus Problem Sets", "Mathematics", "2023", "MATH401", "Free", "Printed", R.drawable.mathematics_problems),
                new CourseMaterial("Anthropology Fieldwork Videos", "Anthropology", "2022", "ANTH101", "Paid", "Virtual", R.drawable.anthropology_videos)
        );
    }

    public static void addCourseMaterial(CourseMaterial material) {
        courseMaterials.add(material);
    }

    public static void removeCourseMaterial(CourseMaterial material) {
        courseMaterials.remove(material);
    }

    // Updating a material by finding it in the list and replacing it
    public static void updateCourseMaterial(CourseMaterial oldMaterial, CourseMaterial newMaterial) {
        int index = courseMaterials.indexOf(oldMaterial);
        if (index != -1) {
            courseMaterials.set(index, newMaterial);
        }
    }

    // ... other methods as needed ...
}
