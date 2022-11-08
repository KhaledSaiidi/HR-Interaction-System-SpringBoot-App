package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.EventSubscription;
import tn.esprit.spring.repositories.EventSubscriptionRepository;
@Service
public class EventSubscriptionServiceImpl implements IServiceEventSubscription {
@Autowired
EventSubscriptionRepository eventSubscriptionRepository;

	@Override
	public List<EventSubscription> retrieveAllEventSubscription() {
		
		return (List<EventSubscription>) eventSubscriptionRepository.findAll();
	}

	@Override
	public EventSubscription addEventSubscription(EventSubscription es) {
		
		return eventSubscriptionRepository.save(es);
	}

	@Override
	public void deleteEventSubscription(int id) {
		eventSubscriptionRepository.deleteById(id);

	}

	@Override
	public EventSubscription updateEventSubscription(EventSubscription es) {
		
		return eventSubscriptionRepository.save(es);
	}

	@Override
	public EventSubscription retrieveEventSubscription(int id) {
		EventSubscription ES = eventSubscriptionRepository.findById(id).get();
		return ES;
	}

}
