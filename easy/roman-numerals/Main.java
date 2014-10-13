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
			long numeral = Long.valueOf(line);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < _romanNumeralValues.length; i++) {
				long numberOfNumerals = numeral / _romanNumeralValues[i];

				for (int j = 0; j < numberOfNumerals; j++) {
					sb.append(_romanNumerals[i]);
				}

				numeral = numeral % _romanNumeralValues[i];
			}

			System.out.println(sb.toString());
		}
	}

	private static String[] _romanNumerals = {
		"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
	};

	private static int[] _romanNumeralValues = {
		1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
	};
}