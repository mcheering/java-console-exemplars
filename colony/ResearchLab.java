/**
 * Subclass representing a hazardous Research Laboratory.
 */
public class ResearchLab extends ColonyStructure {
    private int hazardLevel; // Scale of 1-5

    /**
     * Constructs a ResearchLab instance.
     * Precondition: Names must be non-null and numeric measurements nonnegative. Hazard level must be 1 through 5.
     * Postcondition: The new object stores the supplied values.
     */
    public ResearchLab(String designation, int populationCapacity, int hazardLevel) {
        super(designation, populationCapacity);
        this.hazardLevel = hazardLevel;
    }

    /**
     * Estimates oxygen units needed at full occupancy.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns super.calculateOxygenNeed() + (hazardLevel * 15.0) without changing the object.
     */
    @Override
    public double calculateOxygenNeed() {
        return super.calculateOxygenNeed() + (hazardLevel * 15.0);
    }

    /**
     * Formats this object for the console roster.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns a description and leaves the object unchanged.
     */
    @Override
    public String toString() {
        return super.toString() + " (Type: Bio-Lab, Hazard Level: " + hazardLevel + ")";
    }
}
