package ru.kolkov.parking.service;

import org.springframework.stereotype.Service;
import ru.kolkov.parking.repository.PlaceRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class PlaceService {
    PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
