package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long registrationId;
	private String status;
	@ManyToOne
	private Team team;
	

}
