package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.QuestionsQuiz;
@Repository
public interface AnswerQuizRepository extends CrudRepository<AnswerQuiz, Integer> {
	int countByQuestion(QuestionsQuiz question);

	List<AnswerQuiz> findByQuestionOrderByOrderAsc(QuestionsQuiz question);
}
