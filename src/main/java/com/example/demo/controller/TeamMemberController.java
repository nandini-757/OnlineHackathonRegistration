
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TeamMember;
import com.example.demo.service.TeamMemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/team-members")
@RequiredArgsConstructor
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    @PostMapping("/team/{teamId}/student/{studentId}")
    public TeamMember saveTeamMember(
            @PathVariable Long teamId,
            @PathVariable Long studentId) {
        return teamMemberService.saveTeamMember(teamId, studentId);
    }

    @GetMapping
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberService.getAllTeamMembers();
    }

    @GetMapping("/{teamMemberId}")
    public TeamMember getTeamMemberById(
            @PathVariable Long teamMemberId) {
        return teamMemberService.getTeamMemberById(teamMemberId);
    }

    @DeleteMapping("/{teamMemberId}")
    public String deleteTeamMember(
            @PathVariable Long teamMemberId) {
        teamMemberService.deleteTeamMember(teamMemberId);
        return "Team member deleted successfully";
    }
}
