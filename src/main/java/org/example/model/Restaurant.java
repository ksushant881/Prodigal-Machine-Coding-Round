package org.example.model;

import org.example.enums.FoodType;
import org.example.interfaces.Bookable;

import java.time.LocalDateTime;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Bookable {
    private String name;
    private String city;
    private String area;
    private String cuisine;
    private double rating;
    private double cost;
    private FoodType foodType;
    private List<Table> tables;

    public Restaurant(String name, String city, String area, String cuisine, double rating, double cost) {
        this.name = name;
        this.city = city;
        this.area = area;
        this.cuisine = cuisine;
        this.rating = rating;
        this.cost = cost;
        this.tables = new ArrayList<>();
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public boolean isAvailable(LocalDateTime time) {
        // Check if any table is available at the given time
        return tables.stream().anyMatch(table -> !table.isBooked());
    }

    @Override
    public void book(int people) {
        // Find and book the first available table that can accommodate the given number of people
        for (Table table : tables) {
            if (!table.isBooked() && table.getCapacity() >= people) {
                table.setBooked(true);
                break;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    // Getters and setters
}
