package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.Forum;
import tn.esprit.spring.entities.Subjects;
import tn.esprit.spring.services.IServiceForum;
import tn.esprit.spring.services.IServiceSubjects;

import java.util.List;

@EnableSwagger2
@Api(tags = "Subjects Management")
@RestController
@RequestMapping("/api/Subjects")
public class SubjectsController {
@Autowired
IServiceSubjects subjectsservice;
@Autowired
	IServiceForum serviceForum;
@GetMapping("/Showsubjects/{subjects-id}")
@ResponseBody
public Subjects retrieveSubjects (@PathVariable("subjects-id") int idSubjects ) {
return subjectsservice.retrieveSubjects(idSubjects);
}
@PostMapping("/add")
@ResponseBody
public Subjects addSubjects(@RequestBody Subjects s)
{
	Subjects sub= subjectsservice.addSubjects(s);
return sub;
}

	@GetMapping("/showAll")
	@ResponseBody
	public List<Subjects> retrieveSubjects() {
		return subjectsservice.retrieveAllSubjects();
	}

	@PutMapping("/modify-subjects")
	@ResponseBody
	public Subjects modifySubjects(@RequestBody Subjects subjects) {
		return subjectsservice.updateSubjects(subjects);
	}


	@DeleteMapping("/remove-Subjects/{Subjects-id}")
	@ResponseBody
	public void removeSubject(@PathVariable("Subjects-id") Subjects subjects) {
		subjectsservice.deleteSubjects(subjects);
	}

	@RequestMapping("/affect/{subid}/{forumid}")
	@ResponseBody
	public void affect(@PathVariable("forumid") Integer id, @PathVariable("subid") Integer idSubj ){
	Subjects temp = subjectsservice.retrieveSubjects(idSubj);
	Forum forum = serviceForum.retrieveForum(id);
	temp.setForum(forum);
	subjectsservice.updateSubjects(temp);
	}
}
