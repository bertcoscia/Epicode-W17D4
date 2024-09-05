package bertcoscia.Epicode_W17D4.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Could not find the record with ID " + id);
    }
}
