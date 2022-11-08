package tn.esprit.spring.controllers;

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
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.services.IServiceAnswerQuiz;

@EnableSwagger2
@Api(tags = "Answers Management")
@RestController
@RequestMapping("/api/AnswerQuiz")
public class AnswerQuizController {
@Autowired
IServiceAnswerQuiz ServiceAnswerQuiz;

@GetMapping("/ShowQuizAnswers/{QuizAnswer-id}")
@ResponseBody
public AnswerQuiz retrieveAnswerQuiz(@PathVariable("QuizAnswer-id") int idAnswerQuiz ) {
return ServiceAnswerQuiz.retrieveAnswerQuiz(idAnswerQuiz);
}
@PostMapping("/add-answers")
@ResponseBody
public AnswerQuiz addAnswerQuiz(@RequestBody AnswerQuiz a)
{
	AnswerQuiz answers= ServiceAnswerQuiz.addAnswerQuiz(a);
return answers;
}
@DeleteMapping("/remove-answers/{QuizAnswer-id}")
@ResponseBody
public void removeAnswers(@PathVariable("QuizAnswer-id") int idAnswerQuiz) {
ServiceAnswerQuiz.deleteAnswerQuiz(idAnswerQuiz);
}

@PutMapping("/modify-answers")
@ResponseBody
public AnswerQuiz modifyAnswerQuiz(@RequestBody AnswerQuiz answers) {
return ServiceAnswerQuiz.updateAnswerQuiz(answers);
}
}
