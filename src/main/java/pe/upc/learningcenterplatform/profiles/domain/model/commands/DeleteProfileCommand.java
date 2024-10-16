package pe.upc.learningcenterplatform.profiles.domain.model.commands;

public record DeleteProfileCommand(Integer id) {
    public DeleteProfileCommand {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
    }
}