/**
 * Represents a generic structure built on an extra-solar colony.
 */
public class ColonyStructure {
    private String designation;
    private int populationCapacity;

    /**
     * Constructs a ColonyStructure instance.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> The new object has a placeholder name and a zero measurement.
     */
    public ColonyStructure() {
        this.designation = "Unmapped Sector";
        this.populationCapacity = 0;
    }

    /**
     * Constructs a ColonyStructure instance.
     * <p><strong>Precondition:</strong> Names must be non-null and numeric measurements nonnegative.
     * <p><strong>Postcondition:</strong> The new object stores the supplied values.
     *
     * @param designation the structure name
     * @param populationCapacity the number of people the structure can house
     */
    public ColonyStructure(String designation, int populationCapacity) {
        this.designation = designation;
        this.populationCapacity = populationCapacity;
    }

    /**
     * Reads the stored designation.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns the field value and leaves the object unchanged.
     *
     * @return the structure name
     */
    public String getDesignation() { return designation; }
    /**
     * Reads the stored population capacity.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns the field value and leaves the object unchanged.
     *
     * @return the maximum number of occupants
     */
    public int getPopulationCapacity() { return populationCapacity; }

    /**
     * Estimates oxygen units needed at full occupancy.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns populationCapacity * 1.2 without changing the object.
     *
     * @return the estimated demand in oxygen units
     */
    public double calculateOxygenNeed() {
        return this.populationCapacity * 1.2;
    }

    /**
     * Estimates oxygen units needed at full occupancy.
     * <p><strong>Precondition:</strong> strainFactor must be at least 1.0.
     * <p><strong>Postcondition:</strong> Returns populationCapacity * 1.2 * strainFactor without changing the object.
     *
     * @param strainFactor the atmospheric demand multiplier
     * @return the estimated demand in oxygen units
     */
    public double calculateOxygenNeed(double strainFactor) {
        return this.populationCapacity * 1.2 * strainFactor;
    }

    /**
     * Formats this object for the console roster.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns a description and leaves the object unchanged.
     *
     * @return the formatted roster entry
     */
    public String toString() {
        return "Structure " + designation + " [Max Pop: " + populationCapacity + "]";
    }
}
