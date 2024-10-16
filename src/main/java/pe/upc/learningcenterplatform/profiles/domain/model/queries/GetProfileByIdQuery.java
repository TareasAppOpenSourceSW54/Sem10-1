package pe.upc.learningcenterplatform.profiles.domain.model.queries;

public class GetProfileByIdQuery {
    private final Integer id;

    public GetProfileByIdQuery(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return id;
    }
}