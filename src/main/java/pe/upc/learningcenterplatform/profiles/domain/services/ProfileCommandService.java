package pe.upc.learningcenterplatform.profiles.domain.services;

import pe.upc.learningcenterplatform.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.UpdateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.DeleteProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.aggregates.Profile;

import java.util.Optional;

public interface ProfileCommandService {
    Profile handle(CreateProfileCommand command);
    Profile handle(UpdateProfileCommand command);
    void handle(DeleteProfileCommand command);
}