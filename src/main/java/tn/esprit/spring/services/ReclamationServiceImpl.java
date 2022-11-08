package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Notifications;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repositories.ReclamationRepository;
import tn.esprit.spring.repositories.UserRepository;
@Service
public class ReclamationServiceImpl implements IServiceReclamation {
@Autowired
ReclamationRepository reclamationRepository; 
@Autowired
UserRepository userRepository;
	@Override
	public List<Reclamation> retrieveAllReclamation() {
		return (List<Reclamation>) reclamationRepository.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		return reclamationRepository.save(r) ;
	}

	@Override
	public void deleteReclamation(int id) {
		reclamationRepository.deleteById(id);

	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation retrieveReclamation(int id) {
		Reclamation rec  = reclamationRepository.findById(id).get();
		return rec;		
	}

	@Override
	public Reclamation AddReclamation(Integer id, Reclamation rec) {
		return userRepository.findById(id).map(user -> {
			rec.setUser(user);
			return reclamationRepository.save(rec);
		}).get();
	}

	@Override
	public Long nbreReclamation() {
		// TODO Auto-generated method stub
		return reclamationRepository.count();
	}

	

}
