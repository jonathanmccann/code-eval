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
			for (int i = 1; i <= line.length(); i++) {
				if (line.length() % i == 0) {
					String[] lineParts = splitLine(line, i);

					if (arrayElementsEqual(lineParts)) {
						System.out.println(i);

						break;
					}
				}
			}
		}
	}

	private static String[] splitLine(String line, int period) {
		String[] lineParts = new String[line.length() / period];

		int count = 0;

		for (int i = 0; i < lineParts.length; i++) {
			lineParts[i] = line.substring(count, count + period);

			count += period;
		}

		return lineParts;
	}

	private static boolean arrayElementsEqual(String[] lineParts) {
		for (int i = 0; i < lineParts.length - 1; i++) {
			if (!lineParts[i].equals(lineParts[i + 1])) {
				return false;
			}
		}

		return true;
	}
}