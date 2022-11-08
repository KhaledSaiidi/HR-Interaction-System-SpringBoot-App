package tn.esprit.spring.services;

import tn.esprit.spring.entities.ImageUser;

public interface IImageUserService {

	void affectationImageToUser(int idImageUser, long id);
	
	public Iterable<ImageUser> retreiveAllImage();

}
