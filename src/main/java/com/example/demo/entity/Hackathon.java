package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hackathon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hackathonId;
	private String name;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	
	

}
