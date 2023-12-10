package com.example.gas_station.fuel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gas_station.R;

import java.util.List;

public class FuelAdapter extends RecyclerView.Adapter<FuelViewHolder> implements FuelFragmentListener{

    private List<Fuel> fuel;
    private Context context;

    public FuelAdapter(List<Fuel> fuel) {
        this.fuel = fuel;
    }

    @NonNull
    @Override
    public FuelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View gasStationView = inflater.inflate(R.layout.fuel, parent, false);

        return new FuelViewHolder(gasStationView);
    }

    @Override
    public void onBindViewHolder(@NonNull FuelViewHolder holder, int position) {
        Fuel selectedFuel = fuel.get(position);
        holder.setName(selectedFuel.getName());
        holder.setPrice(selectedFuel.getPrice());

        holder.itemView.setOnClickListener(view -> {
            Bundle bundle  = new Bundle();
            bundle.putParcelable("fuel", selectedFuel);
            bundle.putInt("pos", position);
            FuelDialogFragment fragment = FuelDialogFragment.newInstance(bundle);
            fragment.setListener(this);
            FragmentManager fragmentManager = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
            fragment.show(fragmentManager, "FuelDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return fuel.size();
    }

    @Override
    public void updateItem(int position, Fuel updatedFuel) {
       fuel.set(position, updatedFuel);
       notifyItemChanged(position);
    }
}
