/**
 * Subclass tracing organisms utilizing chemical light generation.
 */
public class BioluminescentFauna extends AbyssOrganism {
    private String emissionColor;

    /**
     * Constructs a BioluminescentFauna instance.
     * <p><strong>Precondition:</strong> Names must be non-null and numeric measurements nonnegative.
     * <p><strong>Postcondition:</strong> The new object stores the supplied values.
     *
     * @param species the species name
     * @param captureDepthMeters the capture depth in meters
     * @param emissionColor the color emitted by the organism
     */
    public BioluminescentFauna(String species, int captureDepthMeters, String emissionColor) {
        super(species, captureDepthMeters);
        this.emissionColor = emissionColor;
    }

    /**
     * Formats this object for the console roster.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns a description and leaves the object unchanged.
     *
     * @return the formatted roster entry
     */
    @Override
    public String toString() {
        return super.toString() + " [Light color: " + emissionColor + "]";
    }
}
