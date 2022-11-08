package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reservation;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
