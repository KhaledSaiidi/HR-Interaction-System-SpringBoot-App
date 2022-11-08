package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Events;

public interface IServiceEvents {

	List<Events> retrieveAllEvents();

	Events addEvents(Events e);

	void deleteEvents(int id);

	Events updateEvents(Events e);

	Events retrieveEvents(int id);

	Events affecterUserAEvent(int idEvent, int idUser);

	void AddAndAffect(List<Events> le, Integer idUser);

//	String maxAttendant();

	public Events modifierEvent(int idEvent, Events events);


	Events afficherEventByDate(Date date);

	List<Events> supprimerAllEventsByDate(Date date);

	String bestEvent();
	String eventIn(Integer id);
	int nbPartner(int id);



}
