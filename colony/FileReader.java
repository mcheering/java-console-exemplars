import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReader {
    /**
     * Reads one string per line.
     * <p><strong>Precondition:</strong> filename must identify a readable UTF-8 file.
     * <p><strong>Postcondition:</strong> Returns the values in file order.
     *
     * @param filename the path to the UTF-8 input file
     * @return one string per input line
     * @throws java.io.IOException if an input file cannot be read
     */
    public static String[] toStringArray(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename)).toArray(new String[0]);
    }

    /**
     * Reads one integer per line.
     * <p><strong>Precondition:</strong> filename must identify a readable UTF-8 file. Each line must contain a whole number in the int range.
     * <p><strong>Postcondition:</strong> Returns the values in file order.
     *
     * @param filename the path to the UTF-8 input file
     * @return one integer per input line
     * @throws java.io.IOException if an input file cannot be read
     * @throws NumberFormatException if a measurement cannot be parsed as an integer
     */
    public static int[] toIntArray(String filename) throws IOException {
        String[] lines = toStringArray(filename);
        int[] values = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            values[i] = Integer.parseInt(lines[i].trim());
        }
        return values;
    }
}
