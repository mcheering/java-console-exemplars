/**
 * Subclass tracing heavy non-backbone deep sea predators.
 */
public class ApexInvertebrate extends AbyssOrganism {
    private double tentacleLengthMeters;

    /**
     * Constructs an ApexInvertebrate instance.
     * <p><strong>Precondition:</strong> Names must be non-null and numeric measurements nonnegative.
     * <p><strong>Postcondition:</strong> The new object stores the supplied values.
     *
     * @param species the species name
     * @param captureDepthMeters the capture depth in meters
     * @param tentacleLengthMeters the simulated tentacle length in meters
     */
    public ApexInvertebrate(String species, int captureDepthMeters, double tentacleLengthMeters) {
        super(species, captureDepthMeters);
        this.tentacleLengthMeters = tentacleLengthMeters;
    }

    /**
     * Estimates pressure in atmospheres for this simulation.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns super.calculatePressure() * 1.08 without changing the object.
     *
     * @return the estimated pressure in atmospheres
     */
    @Override
    public double calculatePressure() {
        return super.calculatePressure() * 1.08;
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
        return super.toString() + " [Apex Form - Appendage Span: " + tentacleLengthMeters + "m]";
    }
}
