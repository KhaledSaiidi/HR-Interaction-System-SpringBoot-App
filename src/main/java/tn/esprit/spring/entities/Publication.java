package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name="publication")
public class Publication extends AuditModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	private String title;
	@Column
	private String publication_txt;
	@ManyToOne
	private User user;
	@Lob
	private byte[] pic;
	//@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	//private List<LikePosts> likes;
	@OneToMany(mappedBy = "pub_id",cascade=CascadeType.ALL)
	private List<Comments> comments;

	@OneToMany
	@JoinColumn(name = "idReadction")
	private List<Reaction> reactions;
	
	

	
}