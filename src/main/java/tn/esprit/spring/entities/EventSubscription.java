package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "EVENT_SUBSCRIPTION")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "EVENT_SUBSCRIPTION_TABLE")
public class EventSubscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEventSubscription;
	@Column(length = 3000)
	private String subscriptionContent;
	@Temporal(TemporalType.DATE)
	private Date dateNotification;
	@Column(length = 3000)
	private int MaxEventSubscriptions;
	@Column(length = 3000)
	private int EventSubscriptions;
	@OneToMany
	@JoinColumn(name ="id")
	@JsonIgnore
	List<User> users;
}
