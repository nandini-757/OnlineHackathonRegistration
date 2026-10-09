
package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Registration;
import com.example.demo.entity.Team;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final TeamRepository teamRepository;

    public Registration saveRegistration(Long teamId, Registration registration) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found"));

        registration.setTeam(team);
        registration.setStatus("PENDING");

        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Long registrationId) {
        return registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not found"));
    }

    public Registration updateRegistration(Long registrationId, Registration registration) {

        Registration existing = getRegistrationById(registrationId);

        existing.setStatus(registration.getStatus());

        return registrationRepository.save(existing);
    }

    // Approve registration
    public Registration approveRegistration(Long registrationId) {

        Registration registration = getRegistrationById(registrationId);
        registration.setStatus("APPROVED");

        return registrationRepository.save(registration);
    }

    // Reject registration
    public Registration rejectRegistration(Long registrationId) {

        Registration registration = getRegistrationById(registrationId);
        registration.setStatus("REJECTED");

        return registrationRepository.save(registration);
    }

    public void deleteRegistration(Long registrationId) {
        registrationRepository.delete(getRegistrationById(registrationId));
    }
}
