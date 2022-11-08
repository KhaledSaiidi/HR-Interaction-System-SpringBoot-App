package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ReservationRepository;
@Service
public class ReservationServiceImpl implements IServiceReservation {
@Autowired
ReservationRepository reservationRepository; 
	@Override
	public List<Reservation> retrieveAllReservation() {
		return  (List<Reservation>) reservationRepository.findAll();

	}

	@Override
	public Reservation addReservation(Reservation r) {
		return reservationRepository.save(r);
	}

	@Override
	public void deleteReservation(int id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		return reservationRepository.save(r);
	}

	@Override
	public Reservation retrieveReservation(int id) {
		Reservation r = reservationRepository.findById(id).get();
		return r;
	}

}
