import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReader {
    /**
     * Reads one string per line.
     * Precondition: filename must identify a readable UTF-8 file.
     * Postcondition: Returns the values in file order.
     */
    public static String[] toStringArray(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename)).toArray(new String[0]);
    }

    /**
     * Reads one integer per line.
     * Precondition: filename must identify a readable UTF-8 file. Each line must contain a whole number in the int range.
     * Postcondition: Returns the values in file order.
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
