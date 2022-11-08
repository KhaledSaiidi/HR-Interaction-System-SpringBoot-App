package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.OfferType;
import tn.esprit.spring.entities.Offers;
@Repository
public interface OfferRepository extends CrudRepository<Offers, Integer> {
	/*@Query("Select COUNT(*) FROM PARTNERSHIPS p where p.OfferType = :OfferType")
	int numberByOffer(@Param("OfferType") OfferType OfferType);*/
}
