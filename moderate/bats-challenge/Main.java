import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				int length = Integer.valueOf(lineArray[0]);

				int distance = Integer.valueOf(lineArray[1]);

				int currentNumberOfBats = Integer.valueOf(lineArray[2]);

				// Remove the six centimeter from both sides
				int usableWireLength = length - 12;

				int numberOfBats = (usableWireLength / distance) - currentNumberOfBats;

				System.out.println(numberOfBats);
			}
		}
	}
}