/**
 * Subclass tracing heavy non-backbone deep sea predators.
 */
public class ApexInvertebrate extends AbyssOrganism {
    private double tentacleLengthMeters;

    /**
     * Constructs a ApexInvertebrate instance.
     * Precondition: Names must be non-null and numeric measurements nonnegative.
     * Postcondition: The new object stores the supplied values.
     */
    public ApexInvertebrate(String species, int captureDepthMeters, double tentacleLengthMeters) {
        super(species, captureDepthMeters);
        this.tentacleLengthMeters = tentacleLengthMeters;
    }

    /**
     * Estimates pressure in atmospheres for this simulation.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns super.calculatePressure() * 1.08 without changing the object.
     */
    @Override
    public double calculatePressure() {
        return super.calculatePressure() * 1.08;
    }

    /**
     * Formats this object for the console roster.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns a description and leaves the object unchanged.
     */
    @Override
    public String toString() {
        return super.toString() + " [Apex Form - Appendage Span: " + tentacleLengthMeters + "m]";
    }
}
