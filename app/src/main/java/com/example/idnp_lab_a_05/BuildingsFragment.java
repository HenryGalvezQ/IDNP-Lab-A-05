package com.example.idnp_lab_a_05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BuildingsFragment extends Fragment {

    private boolean isCathedralExpanded = false;
    private boolean isCloisterExpanded = false;

    private View cathedralItemView;
    private View cathedralDetailView;

    private View cloisterItemView;
    private View cloisterDetailView;

    private LinearLayout mainContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_buildings,
                container, false);

        mainContainer = rootView.findViewById(R.id.mainLinearLayout);

        // Inflate item views
        cathedralItemView = inflater.inflate(R.layout.item_cathedral,
                mainContainer, false);
        cloisterItemView = inflater.inflate(R.layout.item_cloister,
                mainContainer, false);

        // Setup Cathedral item
        initializeCathedralItem();

        // Setup Cloister item
        initializeCloisterItem();

        // Add items to main container
        mainContainer.addView(cathedralItemView);
        mainContainer.addView(cloisterItemView);

        return rootView;
    }

    private void initializeCathedralItem() {
        ImageView cathedralImage = cathedralItemView.findViewById(R.id.cathedralImage);
        ImageHelper.applyCircularMask(cathedralImage, R.drawable.cathedral_image,
                getResources());
        cathedralItemView.setOnClickListener(v -> toggleCathedralView());
    }

    private void initializeCloisterItem() {
        ImageView cloisterImage = cloisterItemView.findViewById(R.id.cloisterImage);
        ImageHelper.applyCircularMask(cloisterImage, R.drawable.cloister_image,
                getResources());
        cloisterItemView.setOnClickListener(v -> toggleCloisterView());
    }

    private void toggleCathedralView() {
        if (isCathedralExpanded) {
            // Collapse: replace detail view with item view
            int index = mainContainer.indexOfChild(cathedralDetailView);
            mainContainer.removeView(cathedralDetailView);
            mainContainer.addView(cathedralItemView, index);
            isCathedralExpanded = false;
        } else {
            // Expand: replace item view with detail view
            if (cathedralDetailView == null) {
                cathedralDetailView = LayoutInflater.from(getContext())
                        .inflate(R.layout.fragment_cathedral, mainContainer, false);
                // Apply circular mask to image in detail view
                ImageView imageView = cathedralDetailView.findViewById(R.id.cathedralImage);
                ImageHelper.applyCircularMask(imageView, R.drawable.cathedral_image,
                        getResources());

                // Set up click listener to collapse
                cathedralDetailView.setOnClickListener(v -> toggleCathedralView());
            }
            int index = mainContainer.indexOfChild(cathedralItemView);
            mainContainer.removeView(cathedralItemView);
            mainContainer.addView(cathedralDetailView, index);
            isCathedralExpanded = true;
        }
    }

    private void toggleCloisterView() {
        if (isCloisterExpanded) {
            // Collapse: replace detail view with item view
            int index = mainContainer.indexOfChild(cloisterDetailView);
            mainContainer.removeView(cloisterDetailView);
            mainContainer.addView(cloisterItemView, index);
            isCloisterExpanded = false;
        } else {
            // Expand: replace item view with detail view
            if (cloisterDetailView == null) {
                cloisterDetailView = LayoutInflater.from(getContext())
                        .inflate(R.layout.fragment_cloister, mainContainer, false);
                // Apply circular mask to image in detail view
                ImageView imageView = cloisterDetailView.findViewById(R.id.cloisterImage);
                ImageHelper.applyCircularMask(imageView, R.drawable.cloister_image,
                        getResources());

                // Set up click listener to collapse
                cloisterDetailView.setOnClickListener(v -> toggleCloisterView());
            }
            int index = mainContainer.indexOfChild(cloisterItemView);
            mainContainer.removeView(cloisterItemView);
            mainContainer.addView(cloisterDetailView, index);
            isCloisterExpanded = true;
        }
    }
}
