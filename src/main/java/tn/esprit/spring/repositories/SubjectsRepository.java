package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Subjects;
@Repository
public interface SubjectsRepository extends CrudRepository<Subjects, Integer> {

}
