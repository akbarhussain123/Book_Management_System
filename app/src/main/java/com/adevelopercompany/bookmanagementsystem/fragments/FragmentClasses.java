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


public class FragmentClasses extends Fragment {

    CardView cvFirst, cvSecond, cvThird, cvFourth, cvFifth, cvSix;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_classes, null, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cvFirst = view.findViewById(R.id.cardFirstClass);
        cvSecond = view.findViewById(R.id.cardSecondClass);
        cvThird = view.findViewById(R.id.cardThirdClass);
        cvFourth = view.findViewById(R.id.cardFourthClass);
        cvFifth = view.findViewById(R.id.cardFifthClass);
        cvSix = view.findViewById(R.id.cardsixthClass);


        Animation textAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.text_animations);
        Animation detailAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.detail_animations);
        cvFirst.startAnimation(textAnimation);
        cvSecond.startAnimation(detailAnimation);
        cvThird.startAnimation(textAnimation);
        cvFourth.startAnimation(detailAnimation);
        cvFifth.startAnimation(textAnimation);
        cvSix.startAnimation(detailAnimation);

        cvThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentClasses_to_fragmentBooks);

            }
        });
    }
}