package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.EventSubscription;

public interface IServiceEventSubscription {
	List<EventSubscription> retrieveAllEventSubscription();

	EventSubscription addEventSubscription (EventSubscription es);

	void deleteEventSubscription (int id);

	EventSubscription updateEventSubscription (EventSubscription es);

	EventSubscription retrieveEventSubscription (int id);
}
