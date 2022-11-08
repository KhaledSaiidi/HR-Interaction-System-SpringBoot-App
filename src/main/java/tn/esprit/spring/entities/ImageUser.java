package tn.esprit.spring.entities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "A_IMAGE_USER")
public class ImageUser{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idImageUser;
	
	
	private String nameImageUser;
	
	
	@Lob
	private byte[] data;

	@ManyToOne
	private User user;





}
