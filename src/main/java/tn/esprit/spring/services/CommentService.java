package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.repositories.CommentsRepository;
import tn.esprit.spring.repositories.PublicationRepository;
import tn.esprit.spring.repositories.UserRepository;
@Service
public class CommentService implements ICommentService {

PublicationRepository publicationRep;
	
	@Autowired
	UserRepository userRep;
	@Autowired
	CommentsRepository com_rep;
	@Override
	public Comments AddComments(int user_id,Comments com,int pub_id) {
		// TODO Auto-generated method stub

		userRep.findById(user_id).map(user -> {
			com.setUser(user);
			return com_rep.save(com);
		}).get();
		return publicationRep.findById(pub_id).map(pub -> {
			com.setPub_id(pub);
			return com_rep.save(com);
		}).get();
	}

}
