package ru.kolkov.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolkov.parking.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
