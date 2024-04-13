package org.example.interfaces;

import java.time.LocalDateTime;

public interface Bookable {
    boolean isAvailable(LocalDateTime time);
    void book(int people);
    String getName();
}
