package pe.upc.learningcenterplatform.profiles.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.UpdateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.DeleteProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.PersonName;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.StreetAddress;
import pe.upc.learningcenterplatform.profiles.domain.services.ProfileCommandService;
import pe.upc.learningcenterplatform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile handle(CreateProfileCommand command) {
        Profile profile = new Profile(
                command.firstName(),
                command.lastName(),
                command.email(),
                command.street(),
                command.number(),
                command.city(),
                command.postalCode(),
                command.country()
        );
        return profileRepository.save(profile);
    }

    @Override
    public Profile handle(UpdateProfileCommand command) {
        Profile profile = profileRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        profile.setName(new PersonName(command.firstName(), command.lastName()));
        profile.setEmail(new EmailAddress(command.email()));
        profile.setAddress(new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country()));
        return profileRepository.save(profile);
    }

    @Override
    public void handle(DeleteProfileCommand command) {
        profileRepository.deleteById(command.id());
    }
}