package tn.esprit.spring.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Partnership;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.EventRepository;
import tn.esprit.spring.repositories.UserRepository;
@Service
public class EventsServiceImpl implements IServiceEvents {
@Autowired
EventRepository eventsRepository;
@Autowired
UserRepository userRepository; 

@Override
	public List<Events> retrieveAllEvents() {
		return (List<Events>) eventsRepository.findAll();
	}
	


	
	@Override
	public void deleteEvents(int id) {
		eventsRepository.deleteById(id);

	}

	@Override
	public Events updateEvents(Events e) {
		
		return  eventsRepository.save(e);
	}

	@Override
	public Events retrieveEvents(int id) {
		Events E = eventsRepository.findById(id).get();
		return E;
	}


	@Override
	public void AddAndAffect(List<Events> le, Integer idUser) {
		User user = userRepository.findById(idUser).orElse(null);
		for (Events events : le) {
			events.setUser(null);
			eventsRepository.save(events);
		}	
	}
	

@Override
public Events affecterUserAEvent(int idEvent, int idUser) {
    Events ev=eventsRepository.findById(idEvent).get();
    User us=userRepository.findById(idUser).get();
    ev.setUser(us);

    return eventsRepository.save(ev);
}
@Override
public Events addEvents(Events e) {
	// TODO Auto-generated method stub
	return eventsRepository.save(e);
}





@Override
public Events modifierEvent(int idEvent,Events events) {
    Events event=eventsRepository.findById(idEvent).orElse(null);

    if(events.getDate()!=null) event.setDate(events.getDate());
    if(events.getEventTopic()!=null) event.setEventTopic(events.getEventTopic());
    if(events.getDescription()!=null) event.setDescription(events.getDescription());
    if(events.getImagePub()!=null)event.setImagePub(events.getImagePub());
    if(events.getVideoPub()!=null)event.setVideoPub(events.getVideoPub());
    if(events.getUser()!=null)event.setUser(events.getUser());

    return eventsRepository.save(event);
}




@Override
public Events afficherEventByDate(Date date) {
	// TODO Auto-generated method stub
	return eventsRepository.getEventsByDate(date);
	
}




@Override
public List<Events> supprimerAllEventsByDate(Date date) {
	// TODO Auto-generated method stub
	return eventsRepository.deleteAllByDate(date);
}


public String eventIn(Integer id){
	//int Days = Period.between(LocalDate.now(),)

	int nbDays = eventsRepository.findById(id).get().getDate().getDate() - LocalDate.now().getDayOfMonth();
	System.out.println(Math.abs(nbDays));
	return ( Math.abs(nbDays) + " days");
}

public String bestEvent(){
	List<Events> events = (List<Events>) eventsRepository.findAll();
	Events eventMax = null;
	int max = -1;
	for (Events e : events){
		if(e.getSubscriptions().size() > max){
			max = e.getSubscriptions().size();
			eventMax = e;
		}
	}
	return eventMax.getName();
}

public int nbPartner(int id){
	Events event = eventsRepository.findById(id).get();
	List<Partnership> partners = event.getPartners();
	return partners.size();
}





}
