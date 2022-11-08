package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Publication;
import tn.esprit.spring.services.IServicePublication;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publication")
public class PublicationController {

	
	@Autowired
	IServicePublication iServicePublication;
	@PostMapping("/add")
	public Publication addPublication(@RequestBody Publication p) {
		return iServicePublication.addPublication(p);
		
	}
	@GetMapping("/{id}/reactions")
	public Integer getCount(@PathVariable Integer id) {
		return iServicePublication.countReactions(id);
	}
	@DeleteMapping("/delete/{id}")
	public void remove(@PathVariable Integer id){
		 iServicePublication.deletePublication(id);
	}
	@GetMapping("/all")
	public List<Publication> getAll(){
		return iServicePublication.retrieveAllPubs();
	}
	@GetMapping("{id}")
	public Optional<Publication> get(@PathVariable Integer id){
		return iServicePublication.getPublicationById(id);
	}

}
