package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

public interface IServiceUser {
	List<User> retrieveAllUsers();

	void deleteUser (Integer id);
	Optional<User> getUserByID (Integer id);
	User updateUser (int id);
	UserDetails loadUserByUsername(String username);

	List<String> loyalUser();




}
