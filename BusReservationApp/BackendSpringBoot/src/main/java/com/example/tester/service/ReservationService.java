package com.example.tester.service;

import com.example.tester.entity.Bus;
import com.example.tester.entity.Reservation;
import com.example.tester.entity.User;
import com.example.tester.repo.BusRepo;
import com.example.tester.repo.ReservationRepo;
import com.example.tester.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;
    
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private BusRepo busRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(int id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        // Ensure User is a managed entity
        Optional<User> userOptional = userRepository.findById(reservation.getUser().getUserId());
        if (userOptional.isPresent()) {
            reservation.setUser(userOptional.get());
        } else {
            throw new IllegalArgumentException("User not found");
        }

        // Ensure Bus is a managed entity
        Optional<Bus> busOptional = busRepository.findById(reservation.getBus().getBusId());
        if (busOptional.isPresent()) {
            reservation.setBus(busOptional.get());
        } else {
            throw new IllegalArgumentException("Bus not found");
        }

        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(int id, Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setPassengerName(reservationDetails.getPassengerName());
            reservation.setPassengerAge(reservationDetails.getPassengerAge());
            reservation.setPassengerGender(reservationDetails.getPassengerGender());
            reservation.setBoardingStop(reservationDetails.getBoardingStop());
            reservation.setAlightingStop(reservationDetails.getAlightingStop());
            reservation.setSeatNumber(reservationDetails.getSeatNumber());
            reservation.setJourneyStatus(reservationDetails.getJourneyStatus());
            reservation.setUser(reservationDetails.getUser());
            reservation.setBus(reservationDetails.getBus());
            return reservationRepository.save(reservation);
        } else {
            return null;
        }
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
