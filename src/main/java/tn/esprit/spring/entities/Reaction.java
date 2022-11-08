package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "REACTIONS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "REACTIONS_TABLE")
public class Reaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReaction;
	@Temporal(TemporalType.DATE)
	private Date reactionDate; 
	@Enumerated(EnumType.STRING)
	private ReactionType ReactionType; 
	@ManyToMany
	@JsonIgnore
    Set<User> users;
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Publication pub;
}
