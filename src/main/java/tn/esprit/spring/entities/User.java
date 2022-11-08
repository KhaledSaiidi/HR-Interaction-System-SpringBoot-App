package tn.esprit.spring.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor


@Entity
public class User{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NaturalId
	@Email
	@NotBlank(message = "User email cannot be null")
	private String email;

	@Column(name = "USERNAME", unique = true)
	private String username;

	@NotNull(message = "Password cannot be null")
	private String password;
	@NotNull
	private String confirmPassword;
	private String firstName;

	private String adress;

	private String lastName;

	private String phoneNumber;

	private String postalCode;
	
	private boolean stateUser;
	
	private Boolean isEmailVerified;
	@Enumerated(EnumType.STRING)
	private sexeType sexeUser;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ImageUser> ImageUser1;


	private String role ="User";
	

	@OneToMany(mappedBy =  "user")
	private List<Reclamation> reclamations = new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "users")
	private List<Offers>offres =new ArrayList<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Partnership> partners = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "users")
	private List<Publicity> publicities = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Forum>forums = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<LikeComments>likeComments = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Comments>comments = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Publication>publication = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Events>events = new ArrayList<>();
	 @ManyToMany (mappedBy = "users")
	 List<Quiz> quizList;

	 @OneToMany
	 @JoinColumn(name ="idEventSubscription" )
	 List<EventSubscription> subscriptions;

	
	public int getUserId() {
		return id;
	}
	
	public User() {
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	

}
