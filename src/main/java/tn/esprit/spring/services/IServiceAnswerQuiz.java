package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.QuestionsQuiz;

public interface IServiceAnswerQuiz {
	List<AnswerQuiz> retrieveAllAnswers();

	AnswerQuiz addAnswerQuiz (AnswerQuiz aq);

	void deleteAnswerQuiz (int id);

	AnswerQuiz updateAnswerQuiz(AnswerQuiz aq);

	AnswerQuiz retrieveAnswerQuiz(int id);
	List<AnswerQuiz> findAnswersByQuestion(QuestionsQuiz question);

	int countAnswersInQuestion(QuestionsQuiz question);
}
