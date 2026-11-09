import java.util.ArrayList;

public class ColonyManager {
    /**
     * Loads the paired records, builds the roster, and runs the analysis.
     * Precondition: Run in the example folder with readable, equal-length data files and nonnegative whole-number measurements.
     * Postcondition: Prints the roster and one assessment per record.
     */
    public static void main(String[] args) throws java.io.IOException {
        // Data Structure 1: Parallel arrays filled via FileReader
        String[] sectors = FileReader.toStringArray("habitats.txt");
        int[] personnel = FileReader.toIntArray("populations.txt");
        if (sectors.length != personnel.length) {
            throw new IllegalArgumentException("The two data files must have the same number of lines.");
        }

        // Data Structure 2: Polymorphic list storing superclass references
        ArrayList<ColonyStructure> baseGrid = new ArrayList<ColonyStructure>();

        // Parsing parallel arrays into objects
        for (int i = 0; i < sectors.length; i++) {
            if (personnel[i] > 100) {
                baseGrid.add(new LifeSupportDome(sectors[i], personnel[i], true));
            } else {
                baseGrid.add(new ResearchLab(sectors[i], personnel[i], 3));
            }
        }

        System.out.println("--- Current Colony Grid Status ---");
        for (ColonyStructure cs : baseGrid) {
            System.out.println(cs);
        }

        System.out.println("\n--- Initializing Resource Audit Algorithm ---");
        evaluateAtmosphere(baseGrid, 50.0, 250.0);
    }

    /**
     * Classifies each record using the simulation thresholds.
     * Precondition: The list and its elements must be non-null. minO2 must be at most maxO2.
     * Postcondition: Prints one classification per element in list order.
     */
    private static void evaluateAtmosphere(ArrayList<ColonyStructure> list, double minO2, double maxO2) {
        for (ColonyStructure cs : list) {
            double totalO2 = cs.calculateOxygenNeed();

            // Compound Boolean statement mapping critical infrastructure safety thresholds
            if (totalO2 >= minO2 && totalO2 <= maxO2) {
                System.out.println("[STABLE] Sector " + cs.getDesignation() + " is within safe breathing boundaries.");
            } else if (totalO2 < minO2 || totalO2 > maxO2) {
                System.out.println("[CRITICAL ALERT] Sector " + cs.getDesignation() + " requires emergency life-support rerouting!");
            }
        }
    }
}
