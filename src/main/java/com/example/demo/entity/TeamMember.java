package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long teamMemberId;
	@ManyToOne
	private Team team;
	@ManyToOne
	private Student student;

}
