package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.Reclamation;

public interface IServiceReclamation {

	List<Reclamation> retrieveAllReclamation();

	Reclamation addReclamation (Reclamation r);

	void deleteReclamation (int id);

	Reclamation updateReclamation (Reclamation r);

	Reclamation retrieveReclamation (int id);
	
	
	Reclamation AddReclamation(Integer id, Reclamation rec);
	
	 public Long nbreReclamation();

}
