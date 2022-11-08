package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.SubscriptionRepository;
@Service
public class SubscriptionServiceImpl implements IServiceSubscription {
@Autowired
SubscriptionRepository subRepository;
	@Override
	public List<Subscription> retrieveAllSubscription() {
		return  (List<Subscription>) subRepository.findAll();
		
	}

	@Override
	public Subscription addSubscription(Subscription s) {
		return subRepository.save(s);
	}

	@Override
	public void deleteSubscription(int id) {
subRepository.deleteById(id);
	}

	@Override
	public Subscription updateSubscription(Subscription s) {
		return subRepository.save(s);
	}

	@Override
	public Subscription retrieveSubscription(int id) {
		Subscription s = subRepository.findById(id).get();
		return s;
	}

}
