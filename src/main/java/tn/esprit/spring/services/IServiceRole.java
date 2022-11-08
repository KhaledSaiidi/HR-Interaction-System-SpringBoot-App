package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Role;

public interface IServiceRole {

	List<Role> retrieveAllRoles();

	Role addRoles (Role r);

	void deleteRoles (int id);

	Role updateRoles (Role r);

	Role retrieveRoles (int id);
}
