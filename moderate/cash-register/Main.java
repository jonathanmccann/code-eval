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
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				String output = null;

				Double purchasePrice = Double.valueOf(lineArray[0]);
				Double cash = Double.valueOf(lineArray[1]);

				purchasePrice = purchasePrice * 100;
				cash = cash * 100;

				Double difference = cash - purchasePrice;

				int integerDifference = difference.intValue();

				if (difference < 0) {
					output = "ERROR";
				}
				else if(difference == 0) {
					output = "ZERO";
				}
				else {
					StringBuilder sb = new StringBuilder();

					for (int i = 0; i < _change.length; i++) {
						int numberOfChange = integerDifference / _change[i];

						for (int j = 0; j < numberOfChange; j++) {
							sb.append(_denominations[i]);
							sb.append(",");
						}

						integerDifference = integerDifference % _change[i];
					}

					output = sb.substring(0, sb.length() - 1);
				}

				System.out.println(output);
			}
		}
	}

	private static String[] _denominations = {
		"ONE HUNDRED", "FIFTY", "TWENTY", "TEN", "FIVE", "TWO", "ONE",
		"HALF DOLLAR", "QUARTER", "DIME", "NICKEL", "PENNY"
	};

	private static int[] _change = {
		10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1
	};
}