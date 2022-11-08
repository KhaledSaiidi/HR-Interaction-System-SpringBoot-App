package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Forum;

public interface IServiceForum {
	List<Forum> retrieveAllForum();

	Forum addForum (Forum f);

	void deleteForum (int id);

	Forum updateForum (Forum f);

	Forum retrieveForum (int id);
}
