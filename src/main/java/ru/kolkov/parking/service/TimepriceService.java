package ru.kolkov.parking.service;

import org.springframework.stereotype.Service;
import ru.kolkov.parking.repository.TimepriceRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class TimepriceService {
    TimepriceRepository timepriceRepository;

    public TimepriceService(TimepriceRepository timepriceRepository) {
        this.timepriceRepository = timepriceRepository;
    }
}
