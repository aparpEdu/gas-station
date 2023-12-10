package com.example.gas_station.fuel;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gas_station.R;

public class FuelViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView price;
    public FuelViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.nameView);
        this.price = itemView.findViewById(R.id.priceView);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setPrice(double price) {
        this.price.setText(String.valueOf(price));
    }
}
