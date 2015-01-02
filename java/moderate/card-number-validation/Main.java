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
			line = line.replaceAll("\\s+", "");

			char[] cardNumber = line.toCharArray();

			int totalSum = 0;

			boolean isDouble = false;

			for (int i = (cardNumber.length - 1); i >= 0; i--) {
				int cardDigit = Character.getNumericValue(cardNumber[i]);

				if (isDouble) {
					cardDigit *= 2;

					if (cardDigit > 9) {
						int firstInteger = cardDigit / 10;
						int secondInteger = cardDigit % 10;

						cardDigit = firstInteger + secondInteger;
					}
				}

				totalSum += cardDigit;

				isDouble = !isDouble;
			}

			if ((totalSum % 10) == 0) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}
}