/**
 * Subclass tracing organisms utilizing chemical light generation.
 */
public class BioluminescentFauna extends AbyssOrganism {
    private String emissionColor;

    /**
     * Constructs a BioluminescentFauna instance.
     * Precondition: Names must be non-null and numeric measurements nonnegative.
     * Postcondition: The new object stores the supplied values.
     */
    public BioluminescentFauna(String species, int captureDepthMeters, String emissionColor) {
        super(species, captureDepthMeters);
        this.emissionColor = emissionColor;
    }

    /**
     * Formats this object for the console roster.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns a description and leaves the object unchanged.
     */
    @Override
    public String toString() {
        return super.toString() + " [Light color: " + emissionColor + "]";
    }
}
