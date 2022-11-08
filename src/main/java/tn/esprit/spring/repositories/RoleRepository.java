package tn.esprit.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.ERole;
import tn.esprit.spring.entities.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	Optional<Role> findByName(ERole name);

}
