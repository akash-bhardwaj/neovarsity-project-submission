package com.scaler.neovarsityproject.models;

public enum VehicleType {
    LARGE("Large"), MEDIUM("Medium"), SMALL("Small");

    private final String label;
    VehicleType(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
