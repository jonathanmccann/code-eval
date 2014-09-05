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
				int firstNumber = 1;

				int secondNumber = 1;

				int total = 0;

				for (int i = 0; i < Integer.valueOf(lineArray[0]); i++) {
					firstNumber = secondNumber;
					secondNumber = total;
					total = firstNumber + secondNumber;
				}

				System.out.println(total);
			}
		}
	}
}