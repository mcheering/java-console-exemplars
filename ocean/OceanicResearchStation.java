import java.util.ArrayList;

public class OceanicResearchStation {
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
        // Data Structure 1: String array pulled from file assets via mandatory methods
        String[] speciesCatalog = FileReader.toStringArray("specimens.txt");
        int[] depthCatalog = FileReader.toIntArray("depths.txt");
        if (speciesCatalog.length != depthCatalog.length) {
            throw new IllegalArgumentException("The two data files must have the same number of lines.");
        }

        // Data Structure 2: ArrayList leveraging polymorphism mechanics
        ArrayList<AbyssOrganism> tankArray = new ArrayList<AbyssOrganism>();

        for (int i = 0; i < speciesCatalog.length; i++) {
            if (speciesCatalog[i].equals("VampireSquid")) {
                tankArray.add(new ApexInvertebrate(speciesCatalog[i], depthCatalog[i], 3.4));
            } else {
                tankArray.add(new BioluminescentFauna(speciesCatalog[i], depthCatalog[i], "Cyan Blue"));
            }
        }

        System.out.println("--- Submersed Laboratory Holding Roster ---");
        for (AbyssOrganism ao : tankArray) {
            System.out.println(ao);
        }

        System.out.println("\n--- Initiating Zone Classification Check ---");
        runZoneAnalysis(tankArray);
        printScenarioChart(tankArray);
    }

    /**
     * Classifies each record using the simulation thresholds.
     * <p><strong>Precondition:</strong> The list and its elements must be non-null.
     * <p><strong>Postcondition:</strong> Prints one classification per element in list order.
     *
     * @param list the roster to inspect in order
     */
    private static void runZoneAnalysis(ArrayList<AbyssOrganism> list) {
        for (AbyssOrganism ao : list) {
            int depth = ao.getCaptureDepthMeters();
            double pressure = ao.calculatePressure();

            // Compound Boolean conditions splitting classification parameters
            if (depth >= 1000 && pressure >= 100.0) {
                System.out.println("[HIGH COMPRESSION] " + ao.getSpecies() + " belongs in high-containment units.");
            } else if (depth < 1000 || pressure < 100.0) {
                System.out.println("[LOW COMPRESSION] " + ao.getSpecies() + " can be housed under lower compression metrics.");
            }
        }
    }

    /**
     * Compares each roster entry under three simulated demand factors.
     * <p><strong>Precondition:</strong> The roster and its entries must be non-null.
     * <p><strong>Postcondition:</strong> Prints one chart row per entry without modifying the roster.
     *
     * @param roster entries to compare in file order
     */
    private static void printScenarioChart(ArrayList<AbyssOrganism> roster) {
        double[] factors = {0.5, 1.0, 1.5};
        System.out.println("\n--- High-compression scenarios ---");
        System.out.println("Columns: 0.50x | 1.00x | 1.50x");
        System.out.println("# = requires high compression (at least 1000 meters and 100 atmospheres); . = outside that condition");
        for (AbyssOrganism organism : roster) {
            StringBuilder row = new StringBuilder();
            // Each cell tests the same record under a different assumption.
            for (double factor : factors) {
                double value = organism.calculatePressure(factor);
                if (organism.getCaptureDepthMeters() >= 1000 && value >= 100) {
                    row.append("  #  ");
                } else {
                    row.append("  .  ");
                }
            }
            System.out.println(row + "  " + organism.getSpecies());
        }
    }
}
