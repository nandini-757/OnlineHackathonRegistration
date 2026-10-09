package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Team;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
	private final ProjectRepository projectRepository;
	private final TeamRepository teamRepository;
	
	public Project saveProject(Long teamId,Project project) {
		Team team=teamRepository.findById(teamId)
				.orElseThrow(()-> new ResourceNotFoundException("Team not found"));
		project.setTeam(team);
		return projectRepository.save(project);
	}
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	public Project getProjectById(Long projectId) {
		return projectRepository.findById(projectId)
				.orElseThrow(()-> new ResourceNotFoundException("Project not found"));
	}
	public Project updateProject(Project project,Long projectId) {
		Project existing=getProjectById(projectId);
		existing.setTitle(project.getTitle());
		existing.setDescription(project.getDescription());
		existing.setStatus(project.getStatus());
		return projectRepository.save(existing);
	}
	public void deleteProject(Long projectId) {
		projectRepository.delete(getProjectById(projectId));
		
	}

}
