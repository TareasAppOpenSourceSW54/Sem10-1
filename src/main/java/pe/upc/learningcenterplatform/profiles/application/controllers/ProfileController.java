package pe.upc.learningcenterplatform.profiles.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenterplatform.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.services.ProfileCommandService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileCommandService profileCommandService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody CreateProfileCommand command) {
        Profile profile = profileCommandService.handle(command);
        return ResponseEntity.ok(profile);
    }
}