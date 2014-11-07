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
				int lowerBound = Integer.valueOf(lineArray[0]);
				int upperBound = Integer.valueOf(lineArray[1]);

				int numberOfPrimes = 0;

				if (lowerBound == 2) {
					numberOfPrimes++;
					lowerBound++;
				}
				else if (lowerBound % 2 == 0) {
					lowerBound++;
				}

				for (int i = lowerBound; i <= upperBound; i += 2) {
					if (isPrime(i)) {
						numberOfPrimes++;
					}
				}

				System.out.println(numberOfPrimes);
			}
		}
	}

	private static boolean isPrime(int n) {
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}