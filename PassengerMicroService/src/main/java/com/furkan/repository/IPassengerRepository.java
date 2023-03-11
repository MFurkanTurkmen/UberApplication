package com.furkan.repository;

import com.furkan.repository.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPassengerRepository extends JpaRepository<Passenger,Long> {
    Optional<Passenger> findOptionalByUsername(String username);
}
