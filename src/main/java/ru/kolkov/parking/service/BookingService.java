package ru.kolkov.parking.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kolkov.parking.entity.Booking;
import ru.kolkov.parking.entity.Customer;
import ru.kolkov.parking.entity.Place;
import ru.kolkov.parking.entity.Timeprice;
import ru.kolkov.parking.repository.BookingRepository;
import ru.kolkov.parking.repository.CustomerRepository;
import ru.kolkov.parking.repository.PlaceRepository;
import ru.kolkov.parking.repository.TimepriceRepository;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingService {
    BookingRepository bookingRepository;
    CustomerRepository customerRepository;
    PlaceRepository placeRepository;
    TimepriceRepository timepriceRepository;

    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository,
                          PlaceRepository placeRepository, TimepriceRepository timepriceRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.placeRepository = placeRepository;
        this.timepriceRepository = timepriceRepository;
    }

    public ResponseEntity create(@RequestBody Booking booking) {
        Customer customer = new Customer();
        Place place = new Place();
        Timeprice timeprice = new Timeprice();

        customer.setName(booking.getName());
        place.setPlace(booking.getPlace());
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        timeprice.setTime(time);
        timeprice.setPrice(booking.getPrice());
        customer.getPlaces().add(place);
        place.getCustomers().add(customer);
        timeprice.getPlaces().add(place);
        place.getTimeprices().add(timeprice);

        customerRepository.save(customer);
        placeRepository.save(place);
        timepriceRepository.save(timeprice);

        return new ResponseEntity("New user created", HttpStatus.OK);
    }

    public List<Booking> read() {
        return bookingRepository.findAll();
    }

    public ResponseEntity update(@RequestBody Booking booking) {
        Customer customer = new Customer();
        Place place = new Place();
        Timeprice timeprice = new Timeprice();

        customer.setName(booking.getName());
        place.setPlace(booking.getPlace());
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        timeprice.setTime(time);
        timeprice.setPrice(booking.getPrice());

        customer.getPlaces().add(place);
        place.getCustomers().add(customer);
        timeprice.getPlaces().add(place);
        place.getTimeprices().add(timeprice);

        place.setId(booking.getId());
        customer.setId(booking.getId());
        timeprice.setId(booking.getId());

        customerRepository.save(customer);
        placeRepository.save(place);
        timepriceRepository.save(timeprice);

        return new ResponseEntity("User updated", HttpStatus.OK);
    }

    public void deleteAll() {
        placeRepository.deleteAll();
        timepriceRepository.deleteAll();
        customerRepository.deleteAll();
    }
}
