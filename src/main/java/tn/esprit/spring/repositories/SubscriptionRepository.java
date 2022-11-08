package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Subscription;
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
	/*@Query("Select s from Subscription s WHERE s.startingDate = CURRENT_DATE")
    public List<Subscription> findTodaysSubs(); */
	
	/*@Query(value="SELECT sum(s.price) FROM Subscription s WHERE s.startingDate BETWEEN :startingDate AND :expirationDate")
	float getTotalMoneyEarned(@Param("beginDate") LocalDate startingDate, @Param("expirationDate") Date expirationDate) ;*/
}
