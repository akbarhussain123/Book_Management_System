package com.adevelopercompany.bookmanagementsystem.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.adevelopercompany.bookmanagementsystem.R;

import org.jetbrains.annotations.NotNull;


public class FragmentBooks extends Fragment {


    CardView cvEnglish, cvMaths, cvGN, cvUrdu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_books, null, false);
        //return inflater.inflate(R.layout.fragment_books, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cvEnglish = view.findViewById(R.id.cardEnglish);
        cvMaths = view.findViewById(R.id.cardMaths);
        cvGN = view.findViewById(R.id.cardGN);
        cvUrdu = view.findViewById(R.id.cardUrdu);
        Animation logoAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.logo_animation);
        cvEnglish.setAnimation(logoAnimation);
        cvMaths.setAnimation(logoAnimation);
        cvGN.setAnimation(logoAnimation);
        cvUrdu.setAnimation(logoAnimation);


        cvEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name","english");
                Navigation.findNavController(view).navigate(R.id.action_fragmentBooks_to_booksImages,bundle);

            }
        });
        cvGN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name","gn");
                Navigation.findNavController(view).navigate(R.id.action_fragmentBooks_to_booksImages,bundle);

            }
        });
    }
}