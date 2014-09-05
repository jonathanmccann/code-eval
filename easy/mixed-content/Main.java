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

			StringBuilder digits = new StringBuilder(lineArray.length);
			StringBuilder words = new StringBuilder(lineArray.length);

			if (lineArray.length > 0) {
				for (int i = 0; i < lineArray.length; i++) {
					if (isNumeric(lineArray[i])) {
						digits.append(lineArray[i] + ",");
					}
					else {
						words.append(lineArray[i] + ",");
					}
				}
			}

			if (words.length() == 0) {
				digits.setLength(digits.length() - 1);

				System.out.println(digits.toString());
			}
			else if (digits.length() == 0) {
				words.setLength(words.length() - 1);

				System.out.println(words.toString());
			}
			else {
				digits.setLength(digits.length() - 1);
				words.setLength(words.length() - 1);

				System.out.println(digits.toString() + "|" + words.toString());
			}
		}
	}

	private static boolean isNumeric(String input) {
		return input.matches("[0-9]+");
	}
}