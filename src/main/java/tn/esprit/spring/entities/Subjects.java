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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
//@Table(name = "SUBJECT_TABLE")
public class Subjects implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubject; 
	@Column(length = 1000)
	private String subjectName; 
	@Column(length = 1000)
	private String subjectDescription; 
	@Enumerated(EnumType.STRING)
	private Subject Subject; 
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
	
	@ManyToOne
	@JsonIgnore
	private Forum forum;
	
	@ManyToOne
	private Partnership partnership;


}

