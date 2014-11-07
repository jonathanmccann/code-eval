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
			long palindromeCandidate = Integer.valueOf(line);

			int count = 1;

			while (true) {
				long reverse = reverseNumber(palindromeCandidate);

				palindromeCandidate = palindromeCandidate + reverse;

				if (palindromeCandidate == reverseNumber(palindromeCandidate)) {
					System.out.println(count + " " + palindromeCandidate);

					break;
				}

				count++;
			}
		}
	}

	private static long reverseNumber(long number) {
		long reverse = 0;

		while (number != 0) {
			reverse = reverse * 10;
			reverse = reverse + (number % 10);
			number = number / 10;
		}

		return reverse;
	}
}