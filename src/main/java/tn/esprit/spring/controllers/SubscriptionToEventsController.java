package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.EventSubscription;
import tn.esprit.spring.services.IServiceEventSubscription;
import tn.esprit.spring.services.IServiceUser;

import java.util.List;
import java.util.Set;

@EnableSwagger2
@Api(tags = "Events Subscription Management")
@RestController
@RequestMapping("/api/EventSubscription")
public class SubscriptionToEventsController {
	@Autowired
	IServiceEventSubscription eventsubService;
	@Autowired
	IServiceUser serviceUser;
	@GetMapping("/ShowEventSubscriptions/{id}")
	@ResponseBody
	public EventSubscription retrieveEventSubscription(@PathVariable("id") int id ) {
	return eventsubService.retrieveEventSubscription(id);
	}
	@PostMapping("/add-eventSub/{userid}")
	@ResponseBody
	public EventSubscription addEventSubscription(@PathVariable Integer userid, @RequestBody EventSubscription e)
	{
		e.setUsers(List.of(serviceUser.getUserByID(userid).get()));
		EventSubscription subToEvents= eventsubService.addEventSubscription(e);
	return subToEvents;
	}
}
