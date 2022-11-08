package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.EventSubscription;
@Repository
public interface EventSubscriptionRepository extends CrudRepository<EventSubscription, Integer> {

}
