/**
 * Represents a generic structure built on an extra-solar colony.
 */
public class ColonyStructure {
    private String designation;
    private int populationCapacity;

    /**
     * Constructs a ColonyStructure instance.
     * Precondition: No caller preparation is required.
     * Postcondition: The new object has a placeholder name and a zero measurement.
     */
    public ColonyStructure() {
        this.designation = "Unmapped Sector";
        this.populationCapacity = 0;
    }

    /**
     * Constructs a ColonyStructure instance.
     * Precondition: Names must be non-null and numeric measurements nonnegative.
     * Postcondition: The new object stores the supplied values.
     */
    public ColonyStructure(String designation, int populationCapacity) {
        this.designation = designation;
        this.populationCapacity = populationCapacity;
    }

    /**
     * Reads the stored designation.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns the field value and leaves the object unchanged.
     */
    public String getDesignation() { return designation; }
    /**
     * Reads the stored population capacity.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns the field value and leaves the object unchanged.
     */
    public int getPopulationCapacity() { return populationCapacity; }

    /**
     * Estimates oxygen units needed at full occupancy.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns populationCapacity * 1.2 without changing the object.
     */
    public double calculateOxygenNeed() {
        return this.populationCapacity * 1.2;
    }

    /**
     * Estimates oxygen units needed at full occupancy.
     * Precondition: strainFactor must be at least 1.0.
     * Postcondition: Returns populationCapacity * 1.2 * strainFactor without changing the object.
     */
    public double calculateOxygenNeed(double strainFactor) {
        return this.populationCapacity * 1.2 * strainFactor;
    }

    /**
     * Formats this object for the console roster.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns a description and leaves the object unchanged.
     */
    public String toString() {
        return "Structure " + designation + " [Max Pop: " + populationCapacity + "]";
    }
}
