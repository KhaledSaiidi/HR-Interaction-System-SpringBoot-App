package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Articles;

import tn.esprit.spring.repositories.ArticlesRepository;
@Service
public class ArticleServiceImpl implements IServiceArticle {
@Autowired
ArticlesRepository articlesRepository;
	@Override
	public List<Articles> retrieveAllArticles() {
		
		return (List<Articles>) articlesRepository.findAll();
	}

	@Override
	public Articles addArticles(Articles a) {
	
		return articlesRepository.save(a);
	}

	@Override
	public void deleteArticles(int id) {
		articlesRepository.deleteById(id);

	}

	@Override
	public Articles updateArticles(Articles a) {
		
		return articlesRepository.save(a);
	}

	@Override
	public Articles retrieveArticles(int id) {
		Articles A = articlesRepository.findById(id).get();
		return A;
	}

}
