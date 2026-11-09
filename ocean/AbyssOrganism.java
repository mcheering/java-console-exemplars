/**
 * Superclass mapping general metrics of bathypelagic marine organisms.
 */
public class AbyssOrganism {
    private String species;
    private int captureDepthMeters;

    /**
     * Constructs a AbyssOrganism instance.
     * Precondition: No caller preparation is required.
     * Postcondition: The new object has a placeholder name and a zero measurement.
     */
    public AbyssOrganism() {
        this.species = "Unidentified Organism";
        this.captureDepthMeters = 0;
    }

    /**
     * Constructs a AbyssOrganism instance.
     * Precondition: Names must be non-null and numeric measurements nonnegative.
     * Postcondition: The new object stores the supplied values.
     */
    public AbyssOrganism(String species, int captureDepthMeters) {
        this.species = species;
        this.captureDepthMeters = captureDepthMeters;
    }

    /**
     * Reads the stored species.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns the field value and leaves the object unchanged.
     */
    public String getSpecies() { return species; }
    /**
     * Reads the stored capture depth meters.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns the field value and leaves the object unchanged.
     */
    public int getCaptureDepthMeters() { return captureDepthMeters; }

    /**
     * Estimates pressure in atmospheres for this simulation.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns 1.0 + (captureDepthMeters / 10.0) without changing the object.
     */
    public double calculatePressure() {
        return 1.0 + (this.captureDepthMeters / 10.0);
    }

    /**
     * Estimates pressure in atmospheres for this simulation.
     * Precondition: salinityModifier must be positive.
     * Postcondition: Returns (1.0 + (captureDepthMeters / 10.0)) * salinityModifier without changing the object.
     */
    public double calculatePressure(double salinityModifier) {
        return (1.0 + (this.captureDepthMeters / 10.0)) * salinityModifier;
    }

    /**
     * Formats this object for the console roster.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns a description and leaves the object unchanged.
     */
    public String toString() {
        return species + " observed at " + captureDepthMeters + " meters down.";
    }
}
