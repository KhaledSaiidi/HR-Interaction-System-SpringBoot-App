package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.QuestionsQuiz;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repositories.QuestionsQuizRepository;

@Service("QuestionService")
@Transactional
public class QuestionQuizServiceImpl implements IServiceQuestionsQuiz{
@Autowired
QuestionsQuizRepository questionsQuizRepository; 
private IServiceAnswerQuiz answerService;

	@Override
	public List<QuestionsQuiz> retrieveAllQuestionsQuiz() {
		return  (List<QuestionsQuiz>) questionsQuizRepository.findAll();

	}

	@Override
	public QuestionsQuiz addQuestionsQuiz(QuestionsQuiz q) {
		return questionsQuizRepository.save(q);

	}

	@Override
	public void deleteQuestionsQuiz(int id) {
		questionsQuizRepository.deleteById(id);		
	}

	@Override
	public QuestionsQuiz updateQuestionsQuiz(QuestionsQuiz q) {
		return questionsQuizRepository.save(q);
	}

	@Override
	public QuestionsQuiz retrieveQuestionsQuiz(int id) {
		QuestionsQuiz q = questionsQuizRepository.findById(id).get();
		return q;
	}

	@Override
	public void setCorrectAnswer(QuestionsQuiz question, AnswerQuiz answer) {
		question.setCorrectAnswer (answer);
		addQuestionsQuiz(question);		
	}

	@Override
	public AnswerQuiz getCorrectAnswer(QuestionsQuiz question) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public AnswerQuiz addAnswerToQuestion(AnswerQuiz answer, QuestionsQuiz question) {
		int count = AnswerQuizServiceImpl.countAnswersInQuestion(question);
		Answer newAnswer = updateAndSaveAnswer(answer, question, count);

		checkQuestionInitialization(question, count, newAnswer);

		return newAnswer;*/


	@Override
	public int countQuestionsInQuiz(Quiz quiz) {
		return questionsQuizRepository.countByQuiz(quiz);
	}

	@Override
	public int countValidQuestionsInQuiz(Quiz quiz) {
		return questionsQuizRepository.countByQuizAndIsValidTrue(quiz);

	}

	@Override

 public Boolean checkIsCorrectAnswer(QuestionsQuiz question, int idAnswer) {
		if (!question.getIsValid() || question.getCorrectAnswer() == null) {
			return false;
		}

		return question.getCorrectAnswer().getidAnswerQuiz().equals(idAnswer);
	}
 
	/*private void mergeQuestions(QuestionsQuiz currentQuestion, QuestionsQuiz newQuestion) {
		currentQuestion.setText(newQuestion.getText());

		if (newQuestion.getOrder() != null)
			currentQuestion.setOrder(newQuestion.getOrder());
	}*/

	@Override
	public AnswerQuiz addAnswerToQuestion(AnswerQuiz answer, QuestionsQuiz question) {
		// TODO Auto-generated method stub
		return null;
	}


}
