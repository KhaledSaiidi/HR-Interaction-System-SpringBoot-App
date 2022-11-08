package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Articles;

public interface IServiceArticle {
	List<Articles> retrieveAllArticles();

	Articles addArticles (Articles a);

	void deleteArticles (int id);

	Articles updateArticles(Articles a);

	Articles retrieveArticles (int id);
}
