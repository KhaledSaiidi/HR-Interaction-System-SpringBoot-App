package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reaction;
@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {

}
