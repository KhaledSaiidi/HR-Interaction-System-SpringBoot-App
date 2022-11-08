package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Notifications;
import tn.esprit.spring.repositories.NotificationRepository;
@Service
public class NotificationsServiceImpl implements IServiceNotifications {
@Autowired
NotificationRepository notificationRepository;
	@Override
	public List<Notifications> retrieveAllNotifications() {
		
		return (List<Notifications>) notificationRepository.findAll();
	}

	@Override
	public Notifications addNotifications(Notifications notif) {
	
		return notificationRepository.save(notif) ;
	}

	@Override
	public void deleteNotifications(int id) {
		notificationRepository.deleteById(id);

	}

	@Override
	public Notifications updateNotifications(Notifications notif) {
		
		return notificationRepository.save(notif);
	}

	@Override
	public Notifications retrieveNotifications(int id) {
		Notifications Notif = notificationRepository.findById(id).get();
		return Notif;
	}

}
