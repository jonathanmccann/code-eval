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
			char[] lineArray = line.toCharArray();

			if (lineArray.length > 0) {
				int counter = 0;
				long totalSum = 0;

				while (counter < lineArray.length) {
					totalSum += Character.getNumericValue(line.charAt(counter));

					counter++;
				}

				System.out.println(totalSum);
			}
		}
	}
}