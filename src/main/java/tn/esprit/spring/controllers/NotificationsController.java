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
import tn.esprit.spring.entities.Notifications;
import tn.esprit.spring.services.IServiceNotifications;

@EnableSwagger2
@Api(tags = "Notifications Management")
@RestController
@RequestMapping("/api/Notifications")
public class NotificationsController {
	@Autowired
	IServiceNotifications serviceNotifications; 
	
	@PostMapping("/add-notifications")
	@ResponseBody
	public Notifications addNotifications(@RequestBody Notifications notif)
	{
		Notifications n = serviceNotifications.addNotifications(notif);
	return n;
	}
	@GetMapping("/ShowNotifications/{Notification-id}")
	@ResponseBody
	public Notifications retrieveNotifications(@PathVariable("Notification-id") int idNotifications ) {
	return serviceNotifications.retrieveNotifications(idNotifications);
	}
}
