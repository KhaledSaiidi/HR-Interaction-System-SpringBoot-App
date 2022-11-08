package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Notifications;
@Repository
public interface NotificationRepository extends CrudRepository<Notifications, Integer> {

}
