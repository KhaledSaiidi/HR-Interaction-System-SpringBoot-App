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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.services.IServiceSubscription;

@EnableSwagger2
@Api(tags = "Subscriptions Management")
@RestController
@RequestMapping("/api/Subscription")
public class SubscriptionController {
	@Autowired
	IServiceSubscription subservice; 

@GetMapping("/ShowSubscription/{Subscription-id}")
@ResponseBody
public Subscription retrieveSubscription(@PathVariable("Subscription-id") int idSubscription ) {
return subservice.retrieveSubscription(idSubscription);
}
@PostMapping("/add-subscription")
@ResponseBody
public Subscription addSubscription(@RequestBody Subscription sub)
{
	Subscription subscription= subservice.addSubscription(sub);
return subscription;
}
@DeleteMapping("/remove-subscription/{subscription-id}")
@ResponseBody
public void removeSubscriptions(@PathVariable("subscription-id") int idSubscription) {
subservice.deleteSubscription(idSubscription);
}

@PutMapping("/modify-subscription")
@ResponseBody
public Subscription modifySubscription(@RequestBody Subscription subscription) {
return subservice.updateSubscription(subscription);
}

}
