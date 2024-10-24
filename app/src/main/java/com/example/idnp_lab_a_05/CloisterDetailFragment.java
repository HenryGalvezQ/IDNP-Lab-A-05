package com.example.idnp_lab_a_05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CloisterDetailFragment extends Fragment {

    private boolean isExpanded = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View detailView = inflater.inflate(R.layout.fragment_cloister, container, false);

        // Aplicar máscara circular a la imagen
        ImageView imageView = detailView.findViewById(R.id.cloisterImage);
        ImageHelper.applyCircularMask(imageView, R.drawable.cloister_image, getResources());

        // Configurar listener para contraer
        detailView.setOnClickListener(v -> toggleView());

        return detailView;
    }

    private void toggleView() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}
