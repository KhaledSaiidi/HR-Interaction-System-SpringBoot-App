package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reaction;
import tn.esprit.spring.repositories.ReactionRepository;
@Service
public class ReactionServiceImpl implements IServiceReaction {
@Autowired
ReactionRepository reactRepository;

	@Override
	public List<Reaction> retrieveAllReactions() {
		return (List<Reaction>) reactRepository.findAll();
	}

	@Override
	public Reaction addReaction(Reaction react) {
		return reactRepository.save(react); 
	}

	@Override
	public void deleteReaction(int id) {
		reactRepository.deleteById(id);
	}

	@Override
	public Reaction updateReaction(Reaction react) {
		return reactRepository.save(react);
	}

	@Override
	public Reaction retrieveReaction(int id) {
		Reaction r = reactRepository.findById(id).get();
		return r;
	}

}
