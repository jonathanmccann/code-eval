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

			int numberOfZeros = Integer.valueOf(lineArray[0]);
			int upperLimit = Integer.valueOf(lineArray[1]);

			int numberOfNumerals = 0;

			for (int i = 1; i <= upperLimit; i++) {
				String binary = Integer.toBinaryString(i);

				int zerosCount = binary.length() - binary.replaceAll("0", "").length();

				if (zerosCount == numberOfZeros) {
					numberOfNumerals++;
				}
			}

			System.out.println(numberOfNumerals);
		}
	}
}