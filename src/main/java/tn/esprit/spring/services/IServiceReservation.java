package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Reservation;

public interface IServiceReservation {

	List<Reservation> retrieveAllReservation();

	Reservation addReservation (Reservation r);

	void deleteReservation (int id);

	Reservation updateReservation (Reservation r);

	Reservation retrieveReservation (int id);

}
