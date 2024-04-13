package org.example.interfaces;

import org.example.enums.FoodType;
import org.example.model.Booking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;

public interface BookingSystem<T extends Bookable> {
    void register(T bookable);
    List<T> search(String name, FoodType type, String city, String area, String cuisine, Double rating, Double cost);
    Future<Booking> bookAsync(T bookable, LocalDateTime time, int people);
}

