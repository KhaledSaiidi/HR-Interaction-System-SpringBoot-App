package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.Articles;

import tn.esprit.spring.services.IServiceArticle;

@EnableSwagger2
@Api(tags = "Articles Management")
@RestController
@RequestMapping("/api/article")
public class ArticleController {
@Autowired
IServiceArticle serviceArticle;

@PostMapping("/add-article")
@ResponseBody
public Articles addArticles(@RequestBody Articles a)
{
Articles A= serviceArticle.addArticles(a);
return A;
}
@DeleteMapping("/remove-article/{article-id}")
@ResponseBody
public void removeArticle(@PathVariable("article-id") int idArticles) {
	serviceArticle.deleteArticles(idArticles);
}

@ResponseBody
@GetMapping("/showArticles")
public List<Articles> getArticles() {
	List<Articles> listArticles = serviceArticle.retrieveAllArticles();
return listArticles;
}
@GetMapping("/showarticle/{article-id}")
@ResponseBody
public Articles retrieveArticles(@PathVariable("article-id") int idArticles) {
return serviceArticle.retrieveArticles(idArticles);
}
@PutMapping("/modify-article")
@ResponseBody
public Articles modifyArticles(@RequestBody Articles a) {
return serviceArticle.updateArticles(a);
}
}
