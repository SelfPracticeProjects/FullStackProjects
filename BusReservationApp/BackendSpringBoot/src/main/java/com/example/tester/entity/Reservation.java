package com.example.tester.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reservationId;
	private String passengerName;
	private int passengerAge;
	private String passengerGender;
	private String boardingStop;
	private String alightingStop;
	private int seatNumber;
	private String journeyStatus;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Bus bus;

	public Reservation(int reservationId, String passengerName, int passengerAge, String passengerGender,
			String boardingStop, String alightingStop, int seatNumber, String journeyStatus, User user, Bus bus) {
		super();
		this.reservationId = reservationId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.boardingStop = boardingStop;
		this.alightingStop = alightingStop;
		this.seatNumber = seatNumber;
		this.journeyStatus = journeyStatus;
		this.user = user;
		this.bus = bus;
	}

	public Reservation() {
		super();
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getBoardingStop() {
		return boardingStop;
	}

	public void setBoardingStop(String boardingStop) {
		this.boardingStop = boardingStop;
	}

	public String getAlightingStop() {
		return alightingStop;
	}

	public void setAlightingStop(String alightingStop) {
		this.alightingStop = alightingStop;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getJourneyStatus() {
		return journeyStatus;
	}

	public void setJourneyStatus(String journeyStatus) {
		this.journeyStatus = journeyStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerGender=" + passengerGender + ", boardingStop=" + boardingStop
				+ ", alightingStop=" + alightingStop + ", seatNumber=" + seatNumber + ", journeyStatus=" + journeyStatus
				+ ", user=" + user + ", bus=" + bus + "]";
	}
	
	
	

}
