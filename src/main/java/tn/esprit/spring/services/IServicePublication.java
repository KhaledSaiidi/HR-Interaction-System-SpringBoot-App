package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Publication;

public interface IServicePublication {
	List<Publication> retrieveAllPubs();
	void deletePublication(int id);
	Optional<Publication> getPublicationById(int id);
	Publication addPublication(Publication p);
	int countReactions (int id);

	//public List<Publication>searchPublications (String pattern);
	
	
	
	//public int countPublicationUser(int idUser);
	
	
//	public Map<Long,Integer>getPublicationsbyViewes();
}
