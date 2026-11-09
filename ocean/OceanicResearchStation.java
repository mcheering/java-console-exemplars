import java.util.ArrayList;

public class OceanicResearchStation {
    /**
     * Loads the paired records, builds the roster, and runs the analysis.
     * Precondition: Run in the example folder with readable, equal-length data files and nonnegative whole-number measurements.
     * Postcondition: Prints the roster and one assessment per record.
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
    }

    /**
     * Classifies each record using the simulation thresholds.
     * Precondition: The list and its elements must be non-null.
     * Postcondition: Prints one classification per element in list order.
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
}
