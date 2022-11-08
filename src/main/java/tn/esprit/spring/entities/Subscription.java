
package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="SUBSCRIPTION_TABLE")
public class Subscription {
	

    @Id
    @Column(nullable = false, updatable = false , name="id_Subscription")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubscription;

    @Column
    @Enumerated(EnumType.STRING)
    private BadgeType BadgeType;

    @Column
    @CreatedDate
    private LocalDate stratingDate =  LocalDate.now();

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;

   
    
    @Column
	private boolean renewal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id")
    private User user;


    @ManyToMany
    private List<Events> events = new ArrayList<>();
   
}