/**
 * Subclass representing a heavy civilian housing dome.
 */
public class LifeSupportDome extends ColonyStructure {
    private boolean hasHydroponics;

    /**
     * Constructs a LifeSupportDome instance.
     * Precondition: Names must be non-null and numeric measurements nonnegative.
     * Postcondition: The new object stores the supplied values.
     */
    public LifeSupportDome(String designation, int populationCapacity, boolean hasHydroponics) {
        super(designation, populationCapacity);
        this.hasHydroponics = hasHydroponics;
    }

    /**
     * Formats this object for the console roster.
     * Precondition: No caller preparation is required.
     * Postcondition: Returns a description and leaves the object unchanged.
     */
    @Override
    public String toString() {
        return super.toString() + " (Type: Residential, Eco-Sustained: " + hasHydroponics + ")";
    }
}
