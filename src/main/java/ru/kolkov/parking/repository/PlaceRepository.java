package ru.kolkov.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolkov.parking.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
