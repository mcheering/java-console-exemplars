/**
 * Subclass representing a heavy civilian housing dome.
 */
public class LifeSupportDome extends ColonyStructure {
    private boolean hasHydroponics;

    /**
     * Constructs a LifeSupportDome instance.
     * <p><strong>Precondition:</strong> Names must be non-null and numeric measurements nonnegative.
     * <p><strong>Postcondition:</strong> The new object stores the supplied values.
     *
     * @param designation the structure name
     * @param populationCapacity the number of people the structure can house
     * @param hasHydroponics whether the dome grows plants hydroponically
     */
    public LifeSupportDome(String designation, int populationCapacity, boolean hasHydroponics) {
        super(designation, populationCapacity);
        this.hasHydroponics = hasHydroponics;
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
        return super.toString() + " (Type: Residential, Eco-Sustained: " + hasHydroponics + ")";
    }
}
