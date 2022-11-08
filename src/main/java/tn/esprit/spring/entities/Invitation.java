package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Invitation {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long idInv;
	
	@Column(name = "emailInv")
	@NotBlank
	@NotEmpty
	private String emailInv;
	
	@Column(name = "descriptionlInv")
	private String descriptionlInv;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getIdInv() {
		return idInv;
	}

	public void setIdInv(long idInv) {
		this.idInv = idInv;
	}

	public String getEmailInv() {
		return emailInv;
	}

	public void setEmailInv(String emailInv) {
		this.emailInv = emailInv;
	}

	public String getDescriptionlInv() {
		return descriptionlInv;
	}

	public void setDescriptionlInv(String descriptionlInv) {
		this.descriptionlInv = descriptionlInv;
	}

	public Invitation() {
		super();
	}

	public Invitation(long idInv, String emailInv, String descriptionlInv, User user) {
		super();
		this.idInv = idInv;
		this.emailInv = emailInv;
		this.descriptionlInv = descriptionlInv;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Invitation [idInv=" + idInv + ", emailInv=" + emailInv + ", descriptionlInv=" + descriptionlInv
				+ ", user=" + user + "]";
	}

}