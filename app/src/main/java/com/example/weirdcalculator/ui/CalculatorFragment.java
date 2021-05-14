package com.example.weirdcalculator.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.weirdcalculator.R;

public class CalculatorFragment extends Fragment {
    private static final String DELETE_ZERO_REGEX = "\\.?0*$";

    private EditText firstNumber;
    private EditText secondNumber;
    private TextView resultText;
    private RadioButton plusButton;
    private RadioButton minusButton;
    private RadioButton multiplyButton;
    private RadioButton divideButton;
    private Button calculateButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

        firstNumber = rootView.findViewById(R.id.first_number);
        secondNumber = rootView.findViewById(R.id.second_number);
        resultText = rootView.findViewById(R.id.tv_result);
        plusButton = rootView.findViewById(R.id.rb_plus);
        minusButton = rootView.findViewById(R.id.rb_minus);
        multiplyButton = rootView.findViewById(R.id.rb_multiply);
        divideButton = rootView.findViewById(R.id.rb_divide);
        calculateButton = rootView.findViewById(R.id.b_calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        return rootView;
    }

    private void calculate() {
        resultText.setText("");

        float result;

        try {
            long first = Long.parseLong(firstNumber.getText().toString());
            long second = Long.parseLong(secondNumber.getText().toString());

            result = doCalculation(first, second);

            resultText.setText(String.valueOf(result).replaceAll(DELETE_ZERO_REGEX, ""));
        } catch (Exception e) {
            Toast.makeText(getContext(), getString(R.string.calculator_error), Toast.LENGTH_LONG).show();
        }

    }

    private float doCalculation(long first, long second) throws ArithmeticException {
        float result = 0f;

        if (plusButton.isChecked()) {
            result = first + second;
        } else if (minusButton.isChecked()) {
            result = first - second;
        } else if (multiplyButton.isChecked()) {
            result = first * second;
        } else if (divideButton.isChecked()) {
            result = (float) first / second;
        }

        return result;
    }
}
