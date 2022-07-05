package ru.kolkov.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolkov.parking.entity.Timeprice;

@Repository
public interface TimepriceRepository extends JpaRepository<Timeprice, Integer> {
}
