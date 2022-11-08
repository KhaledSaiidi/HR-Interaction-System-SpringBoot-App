package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNe;

	@Column(name = "descriptionNews")
	private String descriptionNews;

	@Column(name = "title")
	private String title;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<ImageNews> ImageNews1;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Company_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
    
    
	public long getIdNe() {
		return idNe;
	}

	public void setIdNe(long idNe) {
		this.idNe = idNe;
	}

	public String getDescriptionNews() {
		return descriptionNews;
	}

	public void setDescriptionNews(String descriptionNews) {
		this.descriptionNews = descriptionNews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<ImageNews> getImageNews1() {
		return ImageNews1;
	}

	public void setImageNews1(Set<ImageNews> imageNews1) {
		ImageNews1 = imageNews1;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public News() {
		super();
	}

	public News(long idNe, String descriptionNews, String title,  User user) {
		super();
		this.idNe = idNe;
		this.descriptionNews = descriptionNews;
		this.title = title;
		this.user = user;
	}

	public News(long idNe, String descriptionNews, String title, Set<ImageNews> imageNews1, User user) {
		super();
		this.idNe = idNe;
		this.descriptionNews = descriptionNews;
		this.title = title;
		ImageNews1 = imageNews1;
		this.user = user;
	}

	@Override
	public String toString() {
		return "News [idNe=" + idNe + ", descriptionNews=" + descriptionNews + ", title=" + title + ", ImageNews1="
				+ ImageNews1 + ", user=" + user + "]";
	}

	
	



	


}
