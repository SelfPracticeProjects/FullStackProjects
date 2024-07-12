package com.example.tester.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	private String busType;
	private String busName;
    private String startLocation;
    private String endLocation;
    private int distance;
	private int totalSeates;
	private int bookedSeates;
	private Timestamp departureTime;
	private Timestamp arivalTime;
	private int fare;
	
	public Bus(int busId, String busType, String busName, String startLocation, String endLocation, int distance,
			int totalSeates, int bookedSeates, Timestamp departureTime, Timestamp arivalTime, int fare) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busName = busName;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.distance = distance;
		this.totalSeates = totalSeates;
		this.bookedSeates = bookedSeates;
		this.departureTime = departureTime;
		this.arivalTime = arivalTime;
		this.fare = fare;
	}

	public Bus() {
		super();
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTotalSeates() {
		return totalSeates;
	}

	public void setTotalSeates(int totalSeates) {
		this.totalSeates = totalSeates;
	}

	public int getBookedSeates() {
		return bookedSeates;
	}

	public void setBookedSeates(int bookedSeates) {
		this.bookedSeates = bookedSeates;
	}

	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public Timestamp getArivalTime() {
		return arivalTime;
	}

	public void setArivalTime(Timestamp arivalTime) {
		this.arivalTime = arivalTime;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busName=" + busName + ", startLocation="
				+ startLocation + ", endLocation=" + endLocation + ", distance=" + distance + ", totalSeates="
				+ totalSeates + ", bookedSeates=" + bookedSeates + ", departureTime=" + departureTime + ", arivalTime="
				+ arivalTime + ", fare=" + fare + "]";
	}
	
	
	
	


}
