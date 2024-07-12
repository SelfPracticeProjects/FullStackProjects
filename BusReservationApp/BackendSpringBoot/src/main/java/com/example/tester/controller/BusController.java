package com.example.tester.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tester.entity.Bus;
import com.example.tester.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable int busId) {
        Optional<Bus> bus = busService.getBusById(busId);
        return bus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Bus>> searchBuses(
            @RequestParam String fromCity,
            @RequestParam String toCity) {
        List<Bus> buses = busService.searchBuses(fromCity, toCity);
        if (buses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buses);
    }

    @PostMapping("/addbus")
    public Bus createBus(@RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @PutMapping("/{busId}")
    public ResponseEntity<Bus> updateBus(@PathVariable int busId, @RequestBody Bus busDetails) {
        try {
            Bus updatedBus = busService.updateBus(busId, busDetails);
            return ResponseEntity.ok(updatedBus);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<Void> deleteBus(@PathVariable int busId) {
        try {
            busService.deleteBus(busId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
