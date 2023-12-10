package com.example.gas_station.fuel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.gas_station.R;


public class FuelDialogFragment extends DialogFragment {


    private FuelFragmentListener listener;

    public FuelDialogFragment() {

    }


    public static FuelDialogFragment newInstance(Bundle bundle) {
        FuelDialogFragment fragment = new FuelDialogFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        view.findViewById(R.id.cancel).setOnClickListener(view1 -> dismiss());
        if(bundle != null) {
            Fuel fuel = bundle.getParcelable("fuel");
            if (fuel != null) {
                EditText name = view.findViewById(R.id.editText);
                EditText price = view.findViewById(R.id.editText3);
                EditText quantity = view.findViewById(R.id.editText2);
                name.setText(fuel.getName());
                price.setText(String.valueOf(fuel.getPrice()));
                quantity.setText(String.valueOf(fuel.getQuantity()));
                view.findViewById(R.id.save).setOnClickListener(view1 -> {
                    fuel.setName(name.getText().toString());
                    fuel.setPrice(Double.parseDouble(price.getText().toString()));
                    fuel.setQuantity(Double.parseDouble(quantity.getText().toString()));
                    listener.updateItem(bundle.getInt("pos"), fuel);
                    dismiss();
                });
            }
        }

    }

    public void setListener(FuelFragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fuel_dialog, container, false);
    }
}