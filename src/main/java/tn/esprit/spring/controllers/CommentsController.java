package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.repositories.CommentsRepository;
import tn.esprit.spring.services.CommentService;


@RestController
@RequestMapping("/api/commnents")
public class CommentsController {
	
	/*@Autowired
	CommentService comService;
	@Autowired
	CommentsRepository com_rep;
	@PostMapping("/AddComments/{userId}/{pubId}")
	public String AddComment(@RequestBody Comments com,@PathVariable(value = "userId") int userId,@PathVariable(value = "pubId") int pubId){
		List<String> dic = com_rep.Dictionnaire();
		for (int i = 1; i <= dic.size(); i++) {
			if (com.getComment_field().contains(dic.get(i-1))) {
				break;
			}
			else{
				if (i == dic.size()) {
					comService.AddComments(userId, com, pubId);
					return "comments added succesfully";
				}
			}
			
		}
		return "can not add comment which contains a forbidden word";
	}
	*/
}
