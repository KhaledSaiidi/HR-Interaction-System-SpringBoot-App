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
@Table(name = "A_IMAGE_NEWS")
public class ImageNews implements MultipartFile {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idImageNews ;
	private String nameImageNews;
	@Lob
	private byte[] data;
	@ManyToOne
	News news;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getBytes() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	public int getIdImageNews() {
		return idImageNews;
	}

	public void setIdImageNews(int idImageNews) {
		this.idImageNews = idImageNews;
	}

	public String getNameImageNews() {
		return nameImageNews;
	}

	public void setNameImageNews(String nameImageNews) {
		this.nameImageNews = nameImageNews;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public ImageNews() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ImageNews(String nameImageNews,String contenttype, byte[] data) {
		super();
		this.nameImageNews = nameImageNews;
		this.getContentType();
		this.data = data;
	}

	public ImageNews(int idImageNews, String nameImageNews, byte[] data, News news) {
		super();
		this.idImageNews = idImageNews;
		this.nameImageNews = nameImageNews;
		this.data = data;
		this.news = news;
	}

	public ImageNews(String nameImageNews, byte[] data, News news) {
		super();
		this.nameImageNews = nameImageNews;
		this.data = data;
		this.news = news;
	}

	public ImageNews(int idImageNews, String nameImageNews, byte[] data) {
		super();
		this.idImageNews = idImageNews;
		this.nameImageNews = nameImageNews;
		this.data = data;
	}

	public ImageNews(String nameImageNews, byte[] data) {
		super();
		this.nameImageNews = nameImageNews;
		this.data = data;
	}
	

}
