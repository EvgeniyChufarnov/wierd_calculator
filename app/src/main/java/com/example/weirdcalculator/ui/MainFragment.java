package com.example.weirdcalculator.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.weirdcalculator.R;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button calculatorButton = rootView.findViewById(R.id.b_calculator);
        Button formButton = rootView.findViewById(R.id.b_form);
        Button calendarButton = rootView.findViewById(R.id.b_calendar);
        SwitchCompat switchButton = rootView.findViewById(R.id.switchButton);

        calculatorButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_calculatorFragment)
        );

        formButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_formFragment)
        );

        calendarButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_calendarFragment)
        );

        switchButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        return rootView;
    }
}
