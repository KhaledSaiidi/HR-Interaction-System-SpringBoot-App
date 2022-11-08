package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comments;


public interface ICommentService {

	/*Comments addCommentNews (Comments commentNews) ;
	Comments updateCommentNews(Comments commentNews) ;
	boolean deleteCommentNews(long idCommN);
	List<Comments> retrieveAllCommentNews();
	Comments retrieveCommentNewsById(long idCommN);*/
	
	
	public Comments AddComments(int user_id,Comments com,int pub_id);
	
	
	
	
}
