package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Reaction;

public interface IServiceReaction {
	List<Reaction> retrieveAllReactions();

	Reaction addReaction (Reaction react);

	void deleteReaction (int id);

	Reaction updateReaction (Reaction react);

	Reaction retrieveReaction (int id);

}
