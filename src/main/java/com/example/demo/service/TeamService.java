package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hackathon;
import com.example.demo.entity.Team;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HackathonRepository;
import com.example.demo.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final HackathonRepository hackathonRepository;

    public Team saveTeam(Long hackathonId, Team team) {

        Hackathon hackathon = hackathonRepository.findById(hackathonId)
                .orElseThrow(() -> new ResourceNotFoundException("Hackathon not found"));

        team.setHackathon(hackathon);

        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found"));
    }

    public Team updateTeam(Long teamId, Team team) {

        Team existing = getTeamById(teamId);

        existing.setTeamName(team.getTeamName());
        existing.setCreatedBy(team.getCreatedBy());

        return teamRepository.save(existing);
    }

    public void deleteTeam(Long teamId) {
        teamRepository.delete(getTeamById(teamId));
    }
}