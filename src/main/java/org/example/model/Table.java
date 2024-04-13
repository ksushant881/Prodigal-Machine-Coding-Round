package org.example.model;

public class Table {
    private int capacity;
    private boolean isBooked;

    public Table(int capacity) {
        this.capacity = capacity;
        this.isBooked = false;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}

