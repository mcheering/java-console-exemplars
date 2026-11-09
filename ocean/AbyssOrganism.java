/**
 * Superclass mapping general metrics of bathypelagic marine organisms.
 */
public class AbyssOrganism {
    private String species;
    private int captureDepthMeters;

    /**
     * Constructs an AbyssOrganism instance.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> The new object has a placeholder name and a zero measurement.
     */
    public AbyssOrganism() {
        this.species = "Unidentified Organism";
        this.captureDepthMeters = 0;
    }

    /**
     * Constructs an AbyssOrganism instance.
     * <p><strong>Precondition:</strong> Names must be non-null and numeric measurements nonnegative.
     * <p><strong>Postcondition:</strong> The new object stores the supplied values.
     *
     * @param species the species name
     * @param captureDepthMeters the capture depth in meters
     */
    public AbyssOrganism(String species, int captureDepthMeters) {
        this.species = species;
        this.captureDepthMeters = captureDepthMeters;
    }

    /**
     * Reads the stored species.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns the field value and leaves the object unchanged.
     *
     * @return the species name
     */
    public String getSpecies() { return species; }
    /**
     * Reads the stored capture depth meters.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns the field value and leaves the object unchanged.
     *
     * @return the capture depth in meters
     */
    public int getCaptureDepthMeters() { return captureDepthMeters; }

    /**
     * Estimates pressure in atmospheres for this simulation.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns 1.0 + (captureDepthMeters / 10.0) without changing the object.
     *
     * @return the estimated pressure in atmospheres
     */
    public double calculatePressure() {
        return 1.0 + (this.captureDepthMeters / 10.0);
    }

    /**
     * Estimates pressure in atmospheres for this simulation.
     * <p><strong>Precondition:</strong> salinityModifier must be positive.
     * <p><strong>Postcondition:</strong> Returns (1.0 + (captureDepthMeters / 10.0)) * salinityModifier without changing the object.
     *
     * @param salinityModifier the pressure multiplier for salinity
     * @return the estimated pressure in atmospheres
     */
    public double calculatePressure(double salinityModifier) {
        return (1.0 + (this.captureDepthMeters / 10.0)) * salinityModifier;
    }

    /**
     * Formats this object for the console roster.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns a description and leaves the object unchanged.
     *
     * @return the formatted roster entry
     */
    public String toString() {
        return species + " observed at " + captureDepthMeters + " meters down.";
    }
}
