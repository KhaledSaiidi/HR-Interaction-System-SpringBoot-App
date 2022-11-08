package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.News;


public interface INewsService {
	News addNews (News news) ;
	News updateNews(News news) ;
	boolean deleteNews(long idNe);
	List<News> retrieveAllNews();
	News retrieveNewsById(long idNe);
}
