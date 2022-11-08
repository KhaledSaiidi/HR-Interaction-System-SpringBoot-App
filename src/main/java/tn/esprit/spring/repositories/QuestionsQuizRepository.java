package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.QuestionsQuiz;
import tn.esprit.spring.entities.Quiz;

@Repository
public interface QuestionsQuizRepository extends CrudRepository<QuestionsQuiz, Integer> {
	int countByQuiz(Quiz quiz);

	int countByQuizAndIsValidTrue(Quiz quiz);

	List<QuestionsQuiz> findByQuizOrderByOrderAsc(Quiz quiz);

	List<QuestionsQuiz> findByQuizAndIsValidTrueOrderByOrderAsc(Quiz quiz);
}
