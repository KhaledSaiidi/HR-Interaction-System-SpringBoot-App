package tn.esprit.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.User;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
	Page<Quiz> findByIsPublishedTrue(Pageable pageable);

	Page<Quiz> findByCreatedBy(User user, Pageable pageable);

	/*@Query("select q from Quiz q where q.name like %?1%")
	Page<Quiz> searchByName(String name, Pageable pageable);*/
}
