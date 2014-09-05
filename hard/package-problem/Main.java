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
			String[] lineArray = line.split(":");

			if (lineArray.length > 0) {
				// Initialize items
				String[] items = lineArray[1].split("\\s+");

				// Knapsack capacity
				int W = Integer.valueOf(lineArray[0].trim()) * 100;

				// Number of distinct items
				int n = items.length;

				// Array of item values
				int[] v = new int[n];

				// Array of item weights
				int[] w = new int[n];

				// Array of item index number
				String[] itemIndexNumber = new String[n];

				// Initialize the item arrays
				v[0] = 0;
				w[0] = 0;
				itemIndexNumber[0] = "0";

				for (int i = 1; i < n; i++) {
					String item = items[i].substring(1, items[i].length() - 1);

					String[] itemParts = item.split(",");

					itemIndexNumber[i] = itemParts[0];
					Double weight = Double.valueOf(itemParts[1]) * 100;
					w[i] = weight.intValue();
					v[i] = Integer.valueOf(itemParts[2].substring(1));
				}

				int[][] m = new int[n][W];
				int[][] p = new int[n][W];

				for (int i = 1; i < n; i++) {
					for (int j = 0; j < W; j++) {
						if (w[i] <= j) {
							if (m[i - 1][j] > m[i - 1][j - w[i]] + v[i]) {
								m[i][j] = m[i - 1][j];
								p[i][j] = -1;
							}
							else {
								m[i][j] = m[i - 1][j - w[i]] + v[i];
								p[i][j] = 1;
							}
						}
						else {
							m[i][j] = m[i - 1][j];
							p[i][j] = -1;
						}
					}
				}

				String output = "";

				while (n > 0) {
					if (p[n - 1][W - 1] == 1) {
						if (output == "") {
							output = output.concat(String.valueOf(n - 1));
						}
						else {
							output = String.valueOf(n - 1) + "," + output;
						}

						n--;

						W -= w[n];
					}
					else {
						n--;
					}
				}

				if (output == "") {
					System.out.println("-");
				}
				else {
					System.out.println(output);
				}
			}
		}
	}

}