package org.example.impl;

import org.example.enums.FoodType;
import org.example.interfaces.Bookable;
import org.example.interfaces.BookingSystem;
import org.example.model.Booking;
import org.example.model.Restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class RestaurantBookingSystem implements BookingSystem<Restaurant> {
    private List<Restaurant> bookables;
    private ExecutorService executorService;

    public RestaurantBookingSystem() {
        this.bookables = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(10); // Adjust the thread pool size as needed
    }

    @Override
    public void register(Restaurant bookable) {
        bookables.add(bookable);
    }

    //I thought a better implementation would have been a search criteria class, this is not good
    @Override
    public List<Restaurant> search(String name, FoodType foodType, String city, String area, String cuisine, Double rating, Double cost) {
        return bookables.stream()
                .filter(b -> name == null || b.getName().equalsIgnoreCase(name))
                .filter(b -> city == null || b.getCity().equalsIgnoreCase(city))
                .filter(b -> area == null || b.getArea().equalsIgnoreCase(area))
                .filter(b -> cuisine == null || b.getCuisine().equalsIgnoreCase(cuisine))
                .filter(b -> rating == null || b.getRating() >= rating)
                .filter(b -> cost == null || b.getCost() <= cost)
                .filter(b -> b.getFoodType() == foodType)
                .collect(Collectors.toList());
    }


    @Override
    public Future<Booking> bookAsync(Restaurant bookable, LocalDateTime time, int people) {
        return executorService.submit(() -> {
            if (!bookable.isAvailable(time) || bookable.getTables().stream().filter(e -> e.getCapacity() >= people).toList().isEmpty()) {
                return null; // Booking failed
            }
            bookable.book(people);
            return new Booking(bookable, time, people);
        });
    }
}
