import java.util.ArrayList;

public class ColonyManager {
    /**
     * Loads the paired records, builds the roster, and runs the analysis.
     * <p><strong>Precondition:</strong> Run in the example folder with readable, equal-length data files and nonnegative whole-number measurements.
     * <p><strong>Postcondition:</strong> Prints the roster, one assessment per record, and a scenario chart.
     *
     * @param args command-line arguments (unused)
     * @throws java.io.IOException if an input file cannot be read
     * @throws NumberFormatException if a measurement cannot be parsed as an integer
     * @throws IllegalArgumentException if the input files have different line counts
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
        double minO2 = 50.0;
        double maxO2 = 250.0;
        evaluateAtmosphere(baseGrid, minO2, maxO2);
        printScenarioChart(baseGrid, minO2, maxO2);
    }

    /**
     * Classifies each record using the simulation thresholds.
     * <p><strong>Precondition:</strong> The list and its elements must be non-null. minO2 must be at most maxO2.
     * <p><strong>Postcondition:</strong> Prints one classification per element in list order.
     *
     * @param list the roster to inspect in order
     * @param minO2 the inclusive lower oxygen limit
     * @param maxO2 the inclusive upper oxygen limit
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

    /**
     * Compares each roster entry under three simulated demand factors.
     * <p><strong>Precondition:</strong> The roster and its entries must be non-null.
     * <p><strong>Postcondition:</strong> Prints one chart row per entry without modifying the roster.
     *
     * @param roster entries to compare in file order
     * @param minO2 inclusive lower planning limit
     * @param maxO2 inclusive upper planning limit, at least minO2
     */
    private static void printScenarioChart(ArrayList<ColonyStructure> roster, double minO2, double maxO2) {
        double[] factors = {1.0, 1.25, 1.5};
        System.out.println("\n--- Oxygen reserve scenarios ---");
        System.out.println("Columns: 1.00x | 1.25x | 1.50x");
        System.out.println("# = within the planning range (" + minO2 + " to " + maxO2 + " oxygen units); . = outside that condition");
        for (ColonyStructure structure : roster) {
            StringBuilder row = new StringBuilder();
            // Each cell tests the same record under a different assumption.
            for (double factor : factors) {
                double value = structure.calculateOxygenNeed(factor);
                if (value >= minO2 && value <= maxO2) {
                    row.append("  #  ");
                } else {
                    row.append("  .  ");
                }
            }
            System.out.println(row + "  " + structure.getDesignation());
        }
    }
}
