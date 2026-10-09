package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	private String title;
	private String description;
	private String status;
	@ManyToOne
	private Team team;

}
