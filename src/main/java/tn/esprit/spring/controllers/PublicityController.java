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
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.services.IServicePublicity;

@EnableSwagger2
@Api(tags = "Publicity Management")
@RestController
@RequestMapping("/api/Publicity")
public class PublicityController {
@Autowired
IServicePublicity servicePublicity; 
@GetMapping("/ShowPublicity/{Publicity-id}")
@ResponseBody
public Publicity retrievePublicity(@PathVariable("Publicity-id") int idPublicity  ) {
return servicePublicity.retrievePublicity(idPublicity);
}
@PostMapping("/add-publicity")
@ResponseBody
public Publicity addPublicity(@RequestBody Publicity pub)
{
	Publicity publicity= servicePublicity.addPublicity(pub);
return publicity;
}
@DeleteMapping("/remove-publicity/{publicity-id}")
@ResponseBody
public void removePublicity(@PathVariable("publicity-id") int idPublicity) {
servicePublicity.deletePublicity(idPublicity);
}
@PutMapping("/modify-publicity")
@ResponseBody
public Publicity modifyPublicity(@RequestBody Publicity pub) {
return servicePublicity.updatePublicity(pub);
}
}
