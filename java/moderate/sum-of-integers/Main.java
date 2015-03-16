import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(",");

			List<Integer> digits = new ArrayList<>();

			for (String input : lineArray) {
				digits.add(Integer.valueOf(input));
			}

			int maxEndingHere = digits.get(0);
			int maxSoFar = maxEndingHere;

			for (int i = 1; i < digits.size(); i++) {
				maxEndingHere =
					Math.max(digits.get(i), maxEndingHere + digits.get(i));

				maxSoFar = Math.max(maxSoFar, maxEndingHere);
			}

			System.out.println(maxSoFar);
		}
	}
}