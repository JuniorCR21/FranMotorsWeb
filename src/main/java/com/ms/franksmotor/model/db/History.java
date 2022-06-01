package com.ms.franksmotor.model.db;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Motorbike")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "motorbike_id")
	private Motorbike motorbike;
}
