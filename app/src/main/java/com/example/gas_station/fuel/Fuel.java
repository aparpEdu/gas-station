package com.example.gas_station.fuel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Fuel implements Parcelable {
    private String name;
    private double price;
    private double quantity;


    public Fuel(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    protected Fuel(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        quantity = in.readDouble();
    }

    public static final Creator<Fuel> CREATOR = new Creator<Fuel>() {
        @Override
        public Fuel createFromParcel(Parcel in) {
            return new Fuel(in);
        }

        @Override
        public Fuel[] newArray(int size) {
            return new Fuel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeDouble(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
