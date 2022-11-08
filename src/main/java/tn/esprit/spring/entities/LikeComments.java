package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class LikeComments {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Like_id;
	@Column
	private boolean isLiked;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="com_id")
	private Comments com;
	//@Enumerated(EnumType.STRING)
	//private InteractionComments interactionType;
}
