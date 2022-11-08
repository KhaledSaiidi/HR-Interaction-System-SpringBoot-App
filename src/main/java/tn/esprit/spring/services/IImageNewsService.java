package tn.esprit.spring.services;

import tn.esprit.spring.entities.ImageNews;

public interface IImageNewsService {
void affectationImageToNews(int idImageNews, long idNe);
	
	public Iterable<ImageNews> retreiveAllImage();
}
