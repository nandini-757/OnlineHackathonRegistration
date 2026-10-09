
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Team;
import com.example.demo.service.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/hackathon/{hackathonId}")
    public Team saveTeam(
            @PathVariable Long hackathonId,
            @RequestBody Team team) {
        return teamService.saveTeam(hackathonId, team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }
    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable Long teamId) {
        return teamService.getTeamById(teamId);
    }

    @PutMapping("/{teamId}")
    public Team updateTeam(
            @PathVariable Long teamId,
            @RequestBody Team team) {
        return teamService.updateTeam(teamId, team);
    }

    @DeleteMapping("/{teamId}")
    public String deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
        return "Team deleted successfully";
    }
}
