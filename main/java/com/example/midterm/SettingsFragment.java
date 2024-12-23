package com.example.midterm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private CheckBox checkBoxPizzaDelivery;
    private Spinner spinnerPizzaSize, spinnerQuantity;
    private Switch switchTopping1, switchTopping2;
    private RadioButton radioButtonChicago, radioButtonOven, radioButtonItalian, radioButtonNeapolitan,
            radioButtonCalifornia, radioButtonYork, radioButtonsSicilian, radioButtonGreek;
    private Button setButton;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        checkBoxPizzaDelivery = view.findViewById(R.id.checkBoxPizzaDelivery);
        spinnerPizzaSize = view.findViewById(R.id.spinnerPizzaSize);
        spinnerQuantity = view.findViewById(R.id.spinnerQuantity);
        switchTopping1 = view.findViewById(R.id.switchTopping1);
        switchTopping2 = view.findViewById(R.id.switchTopping2);
        radioButtonChicago = view.findViewById(R.id.radioButtonchicago);
        radioButtonOven = view.findViewById(R.id.radioButtonoven);
        radioButtonItalian = view.findViewById(R.id.radioButtonitalian);
        radioButtonNeapolitan = view.findViewById(R.id.radioButtoneapolitan);
        radioButtonCalifornia = view.findViewById(R.id.radioButtoncalifornia);
        radioButtonYork = view.findViewById(R.id.radioButtonyork);
        radioButtonsSicilian = view.findViewById(R.id.radioButtonsicilian);
        radioButtonGreek = view.findViewById(R.id.radioButtongreek);
        setButton = view.findViewById(R.id.setbtn);

        // Set click listener for the "OK" button
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySettings();
            }
        });
    }

    private void applySettings() {
        // Retrieve user selections and perform actions as needed
        String pizzaSize = spinnerPizzaSize.getSelectedItem().toString();
        String quantity = spinnerQuantity.getSelectedItem().toString();
        boolean pizzaDelivery = checkBoxPizzaDelivery.isChecked();
        boolean topping1 = switchTopping1.isChecked();
        boolean topping2 = switchTopping2.isChecked();

        // Retrieve selected pizza category
        String pizzaCategory = "";
        if (radioButtonChicago.isChecked()) {
            pizzaCategory = "Chicago Style";
        } else if (radioButtonOven.isChecked()) {
            pizzaCategory = "Brick Oven Pizza";
        } else if (radioButtonItalian.isChecked()) {
            pizzaCategory = "Italian Pizza";
        } else if (radioButtonNeapolitan.isChecked()) {
            pizzaCategory = "Neapolitan Pizza";
        } else if (radioButtonCalifornia.isChecked()) {
            pizzaCategory = "California Pizza";
        } else if (radioButtonYork.isChecked()) {
            pizzaCategory = "New York Style Pizza";
        } else if (radioButtonsSicilian.isChecked()) {
            pizzaCategory = "Sicilian Pizza";
        } else if (radioButtonGreek.isChecked()) {
            pizzaCategory = "Greek Pizza";
        }

        // Placeholder: Display a Toast with selected settings
        String message = "Pizza Size: " + pizzaSize +
                "\nQuantity: " + quantity +
                "\nPizza Delivery: " + pizzaDelivery +
                "\nBBQ&Meat: " + topping1 +
                "\nButter&Chili: " + topping2 +
                "\nPizza Category: " + pizzaCategory;

        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();

        // TODO: Perform further actions based on the selected settings

        // Example: Navigate to HomeFragment
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }
}
