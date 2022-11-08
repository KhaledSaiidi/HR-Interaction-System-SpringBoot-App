package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Articles;
@Repository
public interface ArticlesRepository extends CrudRepository<Articles, Integer> {

}
