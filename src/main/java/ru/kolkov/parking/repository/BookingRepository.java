package ru.kolkov.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolkov.parking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
