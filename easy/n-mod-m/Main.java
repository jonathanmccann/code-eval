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
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				int N = Integer.valueOf(lineArray[0]);
				int M = Integer.valueOf(lineArray[1]);

				int quotient = N / M;

				int remainder = N - (M * quotient);

				System.out.println(remainder);
			}
		}
	}
}