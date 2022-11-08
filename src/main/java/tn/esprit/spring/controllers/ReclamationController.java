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
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repositories.ReclamationRepository;
import tn.esprit.spring.services.IServiceReclamation;


@RestController
@RequestMapping("/api/Reclamations")
public class ReclamationController {
@Autowired
IServiceReclamation serviceReclamation; 
@Autowired
ReclamationRepository reclamationRepository;
@GetMapping("/ShowReclamations/{Reclamation-id}")
@ResponseBody
public Reclamation retrieveReclamation(@PathVariable("Reclamation-id") int idReclamation ) {
return serviceReclamation.retrieveReclamation(idReclamation);
}
@PostMapping("/add-reclamations")

public Reclamation addReclamation(@RequestBody Reclamation r)
{
	return serviceReclamation.addReclamation(r);

}
@DeleteMapping("/remove-reclamation/{reclamation-id}")
@ResponseBody
public void removeReclamations(@PathVariable("reclamation-id") int idReclamation) {
serviceReclamation.deleteReclamation(idReclamation);
}
@PutMapping("/modify-reclamations")
@ResponseBody
public Reclamation modifyReclamation(@RequestBody Reclamation reclamations) {
return serviceReclamation.updateReclamation(reclamations);
}
@PostMapping("/add/{idUser}")
public	String AddComplaints(@PathVariable Integer idR, @RequestBody Reclamation rec){
	List<String> dic = reclamationRepository.Dictionnaire();
	for (int i = 1; i <= dic.size(); i++) {
		if (rec.getObjectReclamation().contains(dic.get(i-1))) {
			break;
		}
		else{
			if (i == dic.size()) {
				serviceReclamation.AddReclamation(idR, rec);
				return "complaints added succesfully";
			}
		}
		
	}
	return "can not add complaints which contains a forbidden word";
	


}
@GetMapping("/nbre")
public Long nbreReclamation() {
	return serviceReclamation.nbreReclamation();
}

@GetMapping("/showAll")
public List<Reclamation> showAll(){ return serviceReclamation.retrieveAllReclamation();}
}
