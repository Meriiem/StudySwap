package com.example.studyswap;

// Necessary imports
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CourseMaterialAdapter extends RecyclerView.Adapter<CourseMaterialAdapter.CourseMaterialViewHolder> {

    private final List<CourseMaterial> courseMaterials;
    private final OnItemClickListener onItemClickListener;
    private Context context;

    // Interface for click listener
    public interface OnItemClickListener {
        void onItemClick(CourseMaterial courseMaterial);
    }

    public CourseMaterialAdapter(List<CourseMaterial> courseMaterials, Context context, OnItemClickListener listener) {
        this.courseMaterials = courseMaterials;
        this.context = context;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public CourseMaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course_material, parent, false);
        return new CourseMaterialViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseMaterialViewHolder holder, int position) {
        CourseMaterial currentMaterial = courseMaterials.get(position);
        holder.titleTextView.setText(currentMaterial.getTitle());
        holder.materialImageView.setImageResource(currentMaterial.getImageResourceId());

        // Set the click listener
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(currentMaterial);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseMaterials.size();
    }

    public static class CourseMaterialViewHolder extends RecyclerView.ViewHolder {
        final TextView titleTextView;
        final ImageView materialImageView;

        public CourseMaterialViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            materialImageView = itemView.findViewById(R.id.materialImageView);
        }
    }

    public void updateCourseMaterials(List<CourseMaterial> newMaterials) {
        courseMaterials.clear();
        courseMaterials.addAll(newMaterials);
        notifyDataSetChanged();
    }

}
