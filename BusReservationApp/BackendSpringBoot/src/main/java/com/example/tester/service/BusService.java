package com.example.tester.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tester.entity.Bus;
import com.example.tester.repo.BusRepo;

@Service
public class BusService {

    @Autowired
    private BusRepo busRepository;


    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    
    public List<Bus> searchBuses(String fromCity, String toCity) {
        return busRepository.findByStartLocationAndEndLocation(fromCity, toCity);
    }
    
    public Optional<Bus> getBusById(int busId) {
        return busRepository.findById(busId);
    }

    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus updateBus(int busId, Bus busDetails) {
        Bus bus = busRepository.findById(busId).orElseThrow(() -> new RuntimeException("Bus not found"));

        bus.setBusType(busDetails.getBusType());
        bus.setBusName(busDetails.getBusName());
        bus.setStartLocation(busDetails.getStartLocation());
        bus.setEndLocation(busDetails.getEndLocation());
        bus.setDistance(busDetails.getDistance());
        bus.setTotalSeates(busDetails.getTotalSeates());
        bus.setBookedSeates(busDetails.getBookedSeates());
        bus.setDepartureTime(busDetails.getDepartureTime());
        bus.setArivalTime(busDetails.getArivalTime());
        bus.setFare(busDetails.getFare());

        return busRepository.save(bus);
    }

    public void deleteBus(int busId) {
        Bus bus = busRepository.findById(busId).orElseThrow(() -> new RuntimeException("Bus not found"));
        busRepository.delete(bus);
    }
}
