package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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

@Entity(name = "PARTNERSHIPS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
//@Table(name = "PARTNERSHIP_TABLE")
public class Partnership implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idPartnership; 
		@Column(length = 1000)
		private String partnershipDescription; 
		@Column(length = 1000)
		private String namePartnership; 
		@Column(length = 1000)
		private int EventAttendency;
		private Date dateEvent;
		
		@JsonIgnore
		private int idImage;
		@Column(length = 1000)
		@JsonIgnore
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
		private PartnershipType PartnershipType; 
		@Temporal(TemporalType.DATE)
		private Date datePartnership; 
		
		@OneToMany(mappedBy="partnerships",cascade = CascadeType.ALL)
		@JsonIgnore
	    private Set<Offers> offers;
		
		@OneToMany(mappedBy = "partnership")
		private List<Subjects>  subject;

		@ManyToMany(mappedBy = "partners")
	    private List<Events> events;
		

}
