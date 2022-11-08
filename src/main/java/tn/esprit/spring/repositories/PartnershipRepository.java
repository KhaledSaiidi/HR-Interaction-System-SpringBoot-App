package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.OfferType;
import tn.esprit.spring.entities.Partnership;
@Repository
@EnableJpaRepositories
public interface PartnershipRepository extends CrudRepository<Partnership, Integer> {
	/*@Query("Select COUNT(*) FROM PARTNERSHIPS p where p.OfferType = :OfferType")
	int numberByOffer(@Param("OfferType") OfferType OfferType);*/
}
