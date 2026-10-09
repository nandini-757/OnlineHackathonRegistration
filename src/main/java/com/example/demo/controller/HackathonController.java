
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Hackathon;
import com.example.demo.service.HackathonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/hackathons")
@RequiredArgsConstructor
public class HackathonController {

    private final HackathonService hackathonService;

    @PostMapping
    public Hackathon saveHackathon(@RequestBody Hackathon hackathon) {
        return hackathonService.saveHackathon(hackathon);
    }

    @GetMapping
    public List<Hackathon> getAllHackathons() {
        return hackathonService.getAllHackathons();
    }

    @GetMapping("/{id}")
    public Hackathon getHackathonById(@PathVariable Long id) {
        return hackathonService.getHackathonById(id);
    }

    @PutMapping("/{id}")
    public Hackathon updateHackathon(
            @PathVariable Long id,
            @RequestBody Hackathon hackathon) {
        return hackathonService.updateHackathon(id, hackathon);
    }

    @DeleteMapping("/{id}")
    public String deleteHackathon(@PathVariable Long id) {
        hackathonService.deleteHackathon(id);
        return "Hackathon deleted successfully";
    }
}
