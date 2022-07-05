package ru.kolkov.parking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kolkov.parking.entity.Booking;
import ru.kolkov.parking.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingController {
    private final BookingService bookingService;

    public ParkingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping("/read")
    public List<Booking> read() {
        return bookingService.read();
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping("/delete")
    public void delete() {
        bookingService.deleteAll();
    }
}
