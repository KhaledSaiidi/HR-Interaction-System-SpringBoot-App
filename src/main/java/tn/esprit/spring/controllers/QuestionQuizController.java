package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.QuestionsQuiz;
import tn.esprit.spring.services.IServiceQuestionsQuiz;

@EnableSwagger2
@Api(tags = "Questions Management")
@RestController
@RequestMapping("/api/QuestionsQuiz")
public class QuestionQuizController {
	@Autowired
	IServiceQuestionsQuiz iServiceQuestionsQuiz;
	
	@ResponseBody
	@GetMapping("/ShowQuestions")
	public List<QuestionsQuiz> getQuestions() {
	List<QuestionsQuiz> listQuestions = iServiceQuestionsQuiz.retrieveAllQuestionsQuiz();
	return listQuestions;
	}
	@PostMapping("/add-questions")
	@ResponseBody
	public QuestionsQuiz addQuiz(@RequestBody QuestionsQuiz q)
	{
		QuestionsQuiz questions= iServiceQuestionsQuiz.addQuestionsQuiz(q);
	return questions;
	}
	@DeleteMapping("/remove-questions/{QuizQuestion-id}")
	@ResponseBody
	public void removeQuestions(@PathVariable("QuizQuestion-id") int idQuestion) {
	iServiceQuestionsQuiz.deleteQuestionsQuiz(idQuestion);
	}
	@PutMapping("/modify-questions")
	@ResponseBody
	public QuestionsQuiz modifyQuestions(@RequestBody QuestionsQuiz questions) {
	return iServiceQuestionsQuiz.updateQuestionsQuiz(questions);
	}
	/*@RequestMapping(value = "/{question_id}/correctAnswer", method = RequestMethod.GET)
	@ResponseBody
	public AnswerQuiz getCorrectAnswer(@PathVariable int idQuestion) {
		QuestionsQuiz question = iServiceQuestionsQuiz.find(idQuestion);
		return iServiceQuestionsQuiz.getCorrectAnswer(question);
	}*/

}
