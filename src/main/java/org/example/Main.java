package org.example;

import org.example.enums.FoodType;
import org.example.impl.RestaurantBookingSystem;
import org.example.model.Booking;
import org.example.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        RestaurantBookingSystem restaurantBookingSystem = new RestaurantBookingSystem();

        // Register bookable entities
        Restaurant restaurant = new Restaurant("Restaurant A", "City A", "Area A", "Cuisine A", 4.5, 100);
        restaurantBookingSystem.register(restaurant);

        // Search for bookable entities
        List<Restaurant> foundRestaurants = restaurantBookingSystem.search("Restaurant A", FoodType.VEG, "City A", "Area A", "Cuisine A", 4.5, 100.0);
        System.out.println("Restaurants found: " + foundRestaurants.size());


        // Book a restaurant and hotel asynchronously
        Future<Booking> restaurantBooking = restaurantBookingSystem.bookAsync(foundRestaurants.get(0), LocalDateTime.now(), 2);

        // Retrieve and print the results of the bookings
        try {
            Booking restaurantReservation = restaurantBooking.get();
            System.out.println("Restaurant booking successful: " + restaurantReservation.getBookable().getName());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
