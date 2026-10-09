package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Hackathon;

public interface HackathonRepository extends JpaRepository<Hackathon,Long>{

}
