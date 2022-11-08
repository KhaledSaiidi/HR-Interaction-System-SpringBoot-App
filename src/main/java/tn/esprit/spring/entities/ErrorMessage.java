package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.scheduling.annotation.EnableScheduling;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "Error_Messages")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "Error_Messages_TABLE")
public class ErrorMessage implements Serializable{

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private LocalDateTime timestamp;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 2, max = 100, message = "The status must be between 2 and 20 messages.")
	@NotNull(message = "Please provide a status")
	@Column(name="status")
	private int status;
	@Size(min = 2, max = 100, message = "The message must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a messge")
	@Column(name="message")
	private String message;
	@Size(min = 2, max = 100, message = "The path must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a path")
	@Column(name="path")
	private String path;
	public ErrorMessage(LocalDateTime localDateTime, String message, String path,int status) {
		super();
		this.timestamp = localDateTime;
		this.message = message;
		this.path = path;
		this.status=status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
