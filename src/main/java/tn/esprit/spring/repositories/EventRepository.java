package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Events;
@Repository
public interface EventRepository extends CrudRepository<Events, Integer> {

	 Events getEventsByDate(Date date);
	    List<Events> deleteAllByDate(Date date);
	
	
	//@Query("SELECT E.user, E.user FROM Events E,User P join E.user pp where pp=P")
	//String maxAttendant();
}
