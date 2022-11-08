package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "OFFERS_TABLE")
public class Offers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffer; 
	@Column(length = 1000)
	private String nameOffer; 
	@Column(length = 1000)
	private int MaxOffers;
	@Column(length = 1000)
	private int OffersNumber;
	@Column(length = 1000)
	private String descriptionOffer; 
	@Temporal(TemporalType.DATE)
	private Date dateEvent;
	
	@JsonIgnore
	private int idImage;
	@JsonIgnore
	@Column(length = 1000)
	private String imageName;
	@Column(length = 1000)
	@JsonIgnore
	private String imageType;
	@Column(length = 1000)
	@JsonIgnore
	private String imageURL;
	@Lob
	@JsonIgnore
	private byte[] dataImage;
	@Enumerated(EnumType.STRING)
	private OfferType OfferType; 
	@Temporal(TemporalType.DATE)
	private Date dateOffer; 
	@ManyToOne
	@JsonIgnore
	private Partnership partnerships;
	@ManyToMany
	@JsonIgnore
    Set<User> users;
}
