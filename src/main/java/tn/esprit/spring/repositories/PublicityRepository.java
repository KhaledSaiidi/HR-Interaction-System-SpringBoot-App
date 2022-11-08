package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Publicity;
@Repository
public interface PublicityRepository extends CrudRepository<Publicity, Integer> {

}
