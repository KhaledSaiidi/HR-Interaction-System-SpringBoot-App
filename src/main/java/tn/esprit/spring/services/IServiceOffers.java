package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Offers;

public interface IServiceOffers {
	List<Offers> retrieveAllOffers();

	Offers addOffers (Offers o);

	void deleteOffers (int id);

	Offers updateOffers (Offers o);

	Offers retrieveOffers (int id);
	//void OfferNumberPerPartner();
	
	public Offers affecterOffersPartnership(int idOffer, int idPartnership);

	String bestOffType();

	String mostUsedOff();
}
