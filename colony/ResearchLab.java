/**
 * Subclass representing a hazardous Research Laboratory.
 */
public class ResearchLab extends ColonyStructure {
    private int hazardLevel; // Scale of 1-5

    /**
     * Constructs a ResearchLab instance.
     * <p><strong>Precondition:</strong> Names must be non-null and numeric measurements nonnegative. Hazard level must be 1 through 5.
     * <p><strong>Postcondition:</strong> The new object stores the supplied values.
     *
     * @param designation the structure name
     * @param populationCapacity the number of people the structure can house
     * @param hazardLevel the laboratory hazard rating from 1 to 5
     */
    public ResearchLab(String designation, int populationCapacity, int hazardLevel) {
        super(designation, populationCapacity);
        this.hazardLevel = hazardLevel;
    }

    /**
     * Estimates oxygen units needed at full occupancy.
     * <p><strong>Precondition:</strong> No caller preparation is required.
     * <p><strong>Postcondition:</strong> Returns super.calculateOxygenNeed() + (hazardLevel * 15.0) without changing the object.
     *
     * @return the estimated demand in oxygen units
     */
    @Override
    public double calculateOxygenNeed() {
        return super.calculateOxygenNeed() + (hazardLevel * 15.0);
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
        return super.toString() + " (Type: Bio-Lab, Hazard Level: " + hazardLevel + ")";
    }
}
