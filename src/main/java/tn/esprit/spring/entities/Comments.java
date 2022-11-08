package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Comments extends AuditModel {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String Comment_field;
	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Publication pub_id;
	@OneToMany(mappedBy="com",cascade=CascadeType.ALL)
	private List<LikeComments> like_comments;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment_field() {
		return Comment_field;
	}
	public void setComment_field(String comment_field) {
		Comment_field = comment_field;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPub_id() {
		return pub_id;
	}
	public void setPub_id(Publication pub_id) {
		this.pub_id = pub_id;
	}
	public Comments(int id, String comment_field, User user, Publication pub_id) {
		super();
		this.id = id;
		Comment_field = comment_field;
		this.user = user;
		this.pub_id = pub_id;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<LikeComments> getLike_comments() {
		return like_comments;
	}
	public void setLike_comments(List<LikeComments> like_comments) {
		this.like_comments = like_comments;
	}
	public Comments(String comment_field, User user, Publication pub_id, List<LikeComments> like_comments) {
		super();
		Comment_field = comment_field;
		this.user = user;
		this.pub_id = pub_id;
		this.like_comments = like_comments;
	}
	
	
	
	

}

