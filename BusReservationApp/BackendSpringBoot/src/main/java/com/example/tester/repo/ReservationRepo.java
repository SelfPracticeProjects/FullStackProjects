package com.example.tester.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tester.entity.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}
