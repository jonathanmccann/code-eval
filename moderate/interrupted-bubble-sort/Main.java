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
			String[] lineArray = line.split("\\|");

			if (lineArray.length > 0) {
				String[] digits = lineArray[0].split("\\s+");

				long iterations = Long.valueOf(lineArray[1].trim());

				Long[] digitList = new Long[digits.length];

				for (int i = 0; i < digitList.length; i++) {
					digitList[i] = Long.valueOf(digits[i]);
				}

				boolean swap = false;

				for (int i = 0; i < iterations; i++) {
					swap = false;

					for (int j = 0; j < (digitList.length - 1); j++) {
						if (digitList[j] > digitList[j + 1]) {
							long tempDigit = digitList[j];

							digitList[j] = digitList[j + 1];
							digitList[j + 1] = tempDigit;

							swap = true;
						}
					}

					if (!swap) {
						break;
					}
				}

				StringBuilder sb = new StringBuilder(digitList.length);

				for (long digit : digitList) {
					sb.append(digit + " ");
				}

				sb.setLength(sb.length() - 1);

				System.out.println(sb.toString());
			}
		}
	}
}