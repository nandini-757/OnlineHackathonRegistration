package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hackathon;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HackathonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HackathonService {

    private final HackathonRepository hackathonRepository;

    public Hackathon saveHackathon(Hackathon hackathon) {
        return hackathonRepository.save(hackathon);
    }

    public List<Hackathon> getAllHackathons() {
        return hackathonRepository.findAll();
    }

    public Hackathon getHackathonById(Long hackathonId) {
        return hackathonRepository.findById(hackathonId)
                .orElseThrow(() -> new ResourceNotFoundException("Hackathon not found"));
    }

    public Hackathon updateHackathon(Long hackathonId, Hackathon hackathon) {
        Hackathon existing = getHackathonById(hackathonId);

        existing.setName(hackathon.getName());
        existing.setDescription(hackathon.getDescription());
        existing.setStartDate(hackathon.getStartDate());
        existing.setEndDate(hackathon.getEndDate());

        return hackathonRepository.save(existing);
    }

    public void deleteHackathon(Long hackathonId) {
        hackathonRepository.delete(getHackathonById(hackathonId));
    }
}