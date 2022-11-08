package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.QuestionsQuiz;
import tn.esprit.spring.entities.Quiz;


public interface IServiceQuestionsQuiz {
	List<QuestionsQuiz> retrieveAllQuestionsQuiz();

	QuestionsQuiz addQuestionsQuiz (QuestionsQuiz q);

	void deleteQuestionsQuiz (int id);

	QuestionsQuiz updateQuestionsQuiz (QuestionsQuiz q);

	QuestionsQuiz retrieveQuestionsQuiz (int id);
	
	Boolean checkIsCorrectAnswer(QuestionsQuiz question, int idAnswer);

	void setCorrectAnswer(QuestionsQuiz question, AnswerQuiz answer);

	AnswerQuiz getCorrectAnswer(QuestionsQuiz question);

	AnswerQuiz addAnswerToQuestion(AnswerQuiz answer, QuestionsQuiz question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);

}
