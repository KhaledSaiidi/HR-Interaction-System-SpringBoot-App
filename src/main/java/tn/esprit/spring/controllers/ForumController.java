package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Forum;
import tn.esprit.spring.services.IServiceForum;

import java.util.List;

@EnableSwagger2
@Api(tags = "Forum Management")
@RestController
@RequestMapping("/api/ForumManagement")
public class ForumController {
    @Autowired
IServiceForum serviceForum;
    @PostMapping("/add")
    public Forum addForum(@RequestBody Forum forum) {
        return serviceForum.addForum(forum);
    }
    @ResponseBody
    @GetMapping("/showAll")
    public List<Forum> retrieveAllForum(){
        return serviceForum.retrieveAllForum();
    }

    @GetMapping("/showforum/{forum-id}")
    @ResponseBody
    public Forum retrieveSubjects(@PathVariable("forum-id") int idForum) {
        return serviceForum.retrieveForum(idForum);
    }

    @PutMapping("/modify-forum")
    @ResponseBody
    public Forum modifyForum(@RequestBody Forum forum) {
        return serviceForum.updateForum(forum);
    }


    @DeleteMapping("/remove-forum/{forum-id}")
    @ResponseBody
    public void removeSubject(@PathVariable("forum-id") int idForum) {
        serviceForum.deleteForum(idForum);
    }






}
