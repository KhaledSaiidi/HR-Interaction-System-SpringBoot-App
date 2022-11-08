package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Entity(name = "PUBLICITY")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "PUBLICITY_TABLE")
public class Publicity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPublicity; 
	@Column(length = 1000)
	private String namePublicity; 
	@Column(length = 1000)
	private String descriptionPublicity; 
	@Temporal(TemporalType.DATE)
	private Date datePublicity; 
	private Date dateEvent;
	
	@JsonIgnore
	private int idImage;
	@Column(length = 1000)
	@JsonIgnore
	private String imageName;
	@JsonIgnore
	@Column(length = 1000)
	private String imageType;
	@Column(length = 1000)
	@JsonIgnore
	private String imageURL;
	@Lob
	@JsonIgnore
	private byte[] dataImage;
	@ManyToMany
	@JsonIgnore
    Set<User> users;
	@OneToMany(mappedBy="partnerships")
	@JsonIgnore
    private Set<Offers> offers;
}
