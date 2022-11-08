package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Subscription;

public interface IServiceSubscription {
	List<Subscription> retrieveAllSubscription();

	Subscription addSubscription (Subscription s);

	void deleteSubscription (int id);

	Subscription updateSubscription (Subscription s);

	Subscription retrieveSubscription (int id);
}
