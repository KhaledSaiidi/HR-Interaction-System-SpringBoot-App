package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Subjects;
import tn.esprit.spring.repositories.RoleRepository;
@Service
public class RoleServiceImpl implements IServiceRole{
@Autowired
RoleRepository roleRepository; 
	@Override
	public List<Role> retrieveAllRoles() {
		return  (List<Role>) roleRepository.findAll();

	}

	@Override
	public Role addRoles(Role r) {
		return roleRepository.save(r);
	}

	@Override
	public void deleteRoles(int id) {
roleRepository.deleteById(id);		
	}

	@Override
	public Role updateRoles(Role r) {
		return roleRepository.save(r);
	}

	@Override
	public Role retrieveRoles(int id) {
Role r = roleRepository.findById(id).get();
return r;
}

}
