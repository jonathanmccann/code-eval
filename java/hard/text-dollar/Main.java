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
			if ((line.length() % 3) == 1) {
				line = "00" + line;
			}
			else if ((line.length() % 3) == 2) {
				line = "0" + line;
			}

			String[] integerArray = line.split("(?<=\\G...)");

			int count = integerArray.length;

			StringBuilder sb = new StringBuilder(15);

			for (String integer : integerArray) {
				int dollarAmount = Integer.valueOf(integer);

				if (dollarAmount != 0) {
					while (dollarAmount > 0) {
						if (dollarAmount < 20) {
							sb.append(_UNDER_TWENTY[dollarAmount]);

							dollarAmount = 0;
						}
						else if (dollarAmount < 100) {
							sb.append(_TENS[(dollarAmount / 10) - 2]);

							dollarAmount -= (dollarAmount / 10) * 10;
						}
						else if (dollarAmount < 1000) {
							sb.append(_UNDER_TWENTY[dollarAmount / 100]);
							sb.append("Hundred");

							dollarAmount -= (dollarAmount / 100) * 100;
						}
					}

					if (count == 3) {
						sb.append("Million");
					}
					if (count == 2) {
						sb.append("Thousand");
					}

					count--;
				}
			}

			sb.append("Dollars");

			System.out.println(sb.toString());
		}
	}

	private static final String[] _UNDER_TWENTY = new String[] {
		"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
		"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
		"Sixteen", "Seventeen", "Eighteen", "Nineteen"
	};

	private static final String[] _TENS = new String[] {
		"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
		"Ninety"
	};
}