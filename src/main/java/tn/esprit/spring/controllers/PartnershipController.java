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
import tn.esprit.spring.entities.Partnership;
import tn.esprit.spring.services.IServicePartnership;
@EnableSwagger2
@Api(tags = "Partnerships Management")
@RestController
@RequestMapping("/api/Partnership_Management")
public class PartnershipController {
	@Autowired
	IServicePartnership servicePartnership; 
	@GetMapping("/ShowPartnerships/{Partnership-id}")
	@ResponseBody
	public Partnership retrievePartnership(@PathVariable("Partnership-id") int idPartnership ) {
	return servicePartnership.retrievePartnership(idPartnership);
	}
	@PostMapping("/add-partnership")
	@ResponseBody
	public Partnership addPartnership(@RequestBody Partnership p)
	{
		Partnership part= servicePartnership.addPartnership(p);
	return part;
	}
	@DeleteMapping("/remove-partners/{partnership-id}")
	@ResponseBody
	public void removeAnswers(@PathVariable("partnership-id") int idPartnership) {
	servicePartnership.deletePartnership(idPartnership);
	}

	@PutMapping("/modify-partners")
	@ResponseBody
	public Partnership modifyPartnership(@RequestBody Partnership partners) {
	return servicePartnership.updatePartnership(partners);
	}

	@GetMapping("/bestAtt")
	public String bestAtt(){
		return servicePartnership.bestAtt();
	}

}
