package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Notifications;

public interface IServiceNotifications {
	List<Notifications> retrieveAllNotifications();

	Notifications addNotifications (Notifications notif);

	void deleteNotifications (int id);

	Notifications updateNotifications (Notifications notif);

	Notifications retrieveNotifications (int id);
}
