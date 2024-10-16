package pe.upc.learningcenterplatform.profiles.domain.model.commands;

public record CreateProfileCommand(
        String firstName,
        String lastName,
        String email,
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    public CreateProfileCommand {
        if (firstName == null || lastName == null || email == null || street == null || number == null || city == null || postalCode == null || country == null) {
            throw new IllegalArgumentException("All fields are required");
        }
    }
}