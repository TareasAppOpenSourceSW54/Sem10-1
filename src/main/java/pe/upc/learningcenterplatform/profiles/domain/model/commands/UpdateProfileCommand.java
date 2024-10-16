package pe.upc.learningcenterplatform.profiles.domain.model.commands;

public record UpdateProfileCommand(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    public UpdateProfileCommand {
        if (id == null || firstName == null || lastName == null || email == null || street == null || number == null || city == null || postalCode == null || country == null) {
            throw new IllegalArgumentException("All fields are required");
        }
    }
}