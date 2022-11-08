package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Invitation;


public interface IInvitationService {
	
	Invitation addInvitation (Invitation invitation) ;
	List<Invitation> retrieveAllInvitations();
	Invitation retrieveInvitationById(long idInv);
}
