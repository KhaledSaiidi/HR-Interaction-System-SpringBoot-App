package tn.esprit.spring.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.QuestionsQuiz;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.QuizRepository;
import tn.esprit.spring.repositories.UserRepository;


@Service("QuizService")
@Transactional
public class QuizServiceImpl implements IServiceQuiz {

	private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);
	private QuizRepository quizRepository;
	private UserRepository userRepository;

	private IServiceQuestionsQuiz questionService;

	@Autowired
	public QuizServiceImpl(QuizRepository quizRepository, IServiceQuestionsQuiz questionService) {
		this.quizRepository = quizRepository;
		this.questionService = questionService;
	
	}

	@Override
	public List<Quiz> retrieveAllQuiz() {
		return  (List<Quiz>) quizRepository.findAll();
	}

	@Override
	public Quiz addQuiz(Quiz q) {
		return quizRepository.save(q);
	}

	@Override
	public void deleteQuiz(int id) {
		quizRepository.deleteById(id);		
	}

	@Override
	public Quiz updateQuiz(Quiz q) {
		return quizRepository.save(q);
	}

	@Override
	public Quiz retrieveQuiz(int id) {
		Quiz q = quizRepository.findById(id).get();
		return q;
	}

	public String scoreQuiz(Integer iduser, Integer idquiz){
		User user = userRepository.findById(iduser).get();
		Quiz quiz = quizRepository.findById(idquiz).get();
		if (user.getQuizList().contains(quiz) == false){
			return ("L'utilisateur n'a pas passé ce quiz");
		}
		int score = 0;
		for (QuestionsQuiz q : quiz.getQuestionsQuizs()){
			if (q.getIsValid() == true){
				score += 1;
			}
		}
		return ("Le score de cet utilisateur dans ce quiz est : " + score);
	}
}
