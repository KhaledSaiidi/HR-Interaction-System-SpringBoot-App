package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IServiceQuiz;

@EnableSwagger2
@Api(tags = "Quiz Management")
@RestController
@RequestMapping("/api/Quiz")
public class QuizController {
	@Autowired
	IServiceQuiz iServiceQuiz; 
	@PostMapping("/add-quiz")
	@ResponseBody
	public Quiz addQuiz(@RequestBody Quiz q)
	{
		Quiz quiz= iServiceQuiz.addQuiz(q);
		return quiz;
	}
	@DeleteMapping("/remove-quiz/{Quiz-id}")
	@ResponseBody
	public void removeQuizes(@PathVariable("Quiz-id") int idQuiz) {

		iServiceQuiz.deleteQuiz(idQuiz);
	}
	@GetMapping("/{idu}/{idq}/score")
	public String scoreQuiz(@PathVariable Integer idu,@PathVariable Integer idq){
		return iServiceQuiz.scoreQuiz(idu,idq);
	}
}
