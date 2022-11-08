package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Partnership;

public interface IServicePartnership {
	List<Partnership> retrieveAllPartnership();

	Partnership addPartnership (Partnership p);

	void deletePartnership (int id);

	Partnership updatePartnership (Partnership p);

	Partnership retrievePartnership (int id);
	String bestAtt();
}
