package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long teamId;
	private String teamName;
	@ManyToOne
	private Hackathon hackathon;
	private String createdBy;

}
