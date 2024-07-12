package com.example.tester.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tester.entity.Bus;

public interface BusRepo extends JpaRepository<Bus, Integer>{
    List<Bus> findByStartLocationAndEndLocation(String startLocation, String endLocation);


}
