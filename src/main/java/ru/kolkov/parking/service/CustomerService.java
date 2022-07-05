package ru.kolkov.parking.service;

import org.springframework.stereotype.Service;
import ru.kolkov.parking.repository.CustomerRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
