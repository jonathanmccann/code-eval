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
			String[] lineArray = line.split(" \\| ");

			if (lineArray.length > 0) {
				String developerString = lineArray[0];
				String designString = lineArray[1];

				int bugs = 0;

				for (int i = 0; i < developerString.length(); i++) {
					if (developerString.charAt(i) != designString.charAt(i)) {
						bugs++;
					}
				}

				if (bugs == 0) {
					System.out.println("Done");
				}
				else if (bugs <= 2) {
					System.out.println("Low");
				}
				else if (bugs <= 4) {
					System.out.println("Medium");
				}
				else if (bugs <= 6) {
					System.out.println("High");
				}
				else {
					System.out.println("Critical");
				}
			}
		}
	}
}