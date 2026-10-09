
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Registration;
import com.example.demo.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/team/{teamId}")
    public Registration saveRegistration(
            @PathVariable Long teamId,
            @RequestBody Registration registration) {
        return registrationService.saveRegistration(teamId, registration);
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{registrationId}")
    public Registration getRegistrationById(
            @PathVariable Long registrationId) {
        return registrationService.getRegistrationById(registrationId);
    }

    @PutMapping("/{registrationId}")
    public Registration updateRegistration(
            @PathVariable Long registrationId,
            @RequestBody Registration registration) {
        return registrationService.updateRegistration(registrationId, registration);
    }

    @PutMapping("/{registrationId}/approve")
    public Registration approveRegistration(
            @PathVariable Long registrationId) {
        return registrationService.approveRegistration(registrationId);
    }

    @PutMapping("/{registrationId}/reject")
    public Registration rejectRegistration(
            @PathVariable Long registrationId) {
        return registrationService.rejectRegistration(registrationId);
    }

    @DeleteMapping("/{registrationId}")
    public String deleteRegistration(
            @PathVariable Long registrationId) {
        registrationService.deleteRegistration(registrationId);
        return "Registration deleted successfully";
    }
}
