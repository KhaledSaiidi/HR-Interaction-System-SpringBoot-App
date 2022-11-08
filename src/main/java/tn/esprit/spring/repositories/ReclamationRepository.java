package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reclamation;
@Repository
public interface ReclamationRepository extends CrudRepository< Reclamation, Integer> {

	@Query(value="select mots from dictionnaire", nativeQuery=true)
	List<String> Dictionnaire();
}