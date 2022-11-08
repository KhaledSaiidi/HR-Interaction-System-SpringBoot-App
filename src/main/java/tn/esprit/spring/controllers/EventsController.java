package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.services.IServiceEvents;
import tn.esprit.spring.services.IServiceUser;

@EnableSwagger2
@Api(tags = "Events Management")
@RestController
@RequestMapping("/api/events")
public class EventsController {
	@Autowired
	IServiceEvents serviceEvents;
	//@Autowired
	//IServiceUser iServiceUser;

	@ResponseBody
	@GetMapping("/showEvents")
	public 	List<Events> retrieveAllEvents(){
		return serviceEvents.retrieveAllEvents();
	}

	@GetMapping("/showevent/{event-id}")
	@ResponseBody
	public Events retrieveArticles(@PathVariable("event-id") int idEvent) {
		return serviceEvents.retrieveEvents(idEvent);
	}

	@PutMapping("/modify-event")
	@ResponseBody
	public Events modifyEvents(@RequestBody Events e) {
		return serviceEvents.updateEvents(e);
	}

	
	@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeArticle(@PathVariable("event-id") int idEvent) {
		serviceEvents.deleteEvents(idEvent);
	}

	
	@PostMapping("/add")
	public Events addEvents(@RequestBody Events e) {
		return serviceEvents.addEvents(e);
	}
	
	  @GetMapping("affectUser/{idEvent}/{idUser}")
	    public Events affecterUserAEvent(@PathVariable int idEvent,@PathVariable int idUser){
	        return serviceEvents.affecterUserAEvent(idEvent,idUser);
	    }
	  
	//  @GetMapping("/max")
	 // public String maxAttendant() {
		//  return serviceEvents.maxAttendant();}
		  
	  
	  @PutMapping("/{id}")
	    public Events updateEventById(@PathVariable int id,@RequestBody Events events){
	        return serviceEvents.modifierEvent(id,events);
	    }
	  @DeleteMapping("/byDate")
	    public List<Events> deleteEventById(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
	        return serviceEvents.supprimerAllEventsByDate(date);
	    }
	  @GetMapping("/byDate")
	    public Events getEventByDate(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
	        return serviceEvents.afficherEventByDate(date);
	    }
		@GetMapping("/bestEvent")
	public String bestEvent(){
		return serviceEvents.bestEvent();
		}

		@GetMapping("/{id}/remainingDays")
	public String remainingDays(@PathVariable Integer id){

		return serviceEvents.eventIn(id);
		}

	@GetMapping("/{id}/nbPartners")
	public int nbPart(@PathVariable int id){

		return serviceEvents.nbPartner(id);
	}
}
