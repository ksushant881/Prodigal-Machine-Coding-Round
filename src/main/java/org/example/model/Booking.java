package org.example.model;

import org.example.interfaces.Bookable;

import java.time.LocalDateTime;

public class Booking {
    private Bookable bookable;
    private LocalDateTime bookingTime;
    private int people;

    public Booking(Bookable bookable, LocalDateTime bookingTime, int people) {
        this.bookable = bookable;
        this.bookingTime = bookingTime;
        this.people = people;
    }

    public Bookable getBookable() {
        return bookable;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public int getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookable=" + bookable.getName() +
                ", bookingTime=" + bookingTime +
                ", people=" + people +
                '}';
    }
}
