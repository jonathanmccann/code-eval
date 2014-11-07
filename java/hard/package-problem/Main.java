import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

				int packageTotalWeight = Integer.valueOf(lineArray[0].trim()) * 100;
				int numberOfItems = items.length;

				int[] values = new int[numberOfItems];
				int[] weights = new int[numberOfItems];

				// Initialize the item arrays with null first value
				values[0] = 0;
				weights[0] = 0;

				for (int i = 1; i < numberOfItems; i++) {
					String item = items[i].substring(1, items[i].length() - 1);

					String[] itemParts = item.split(",");

					Double weight = Double.valueOf(itemParts[1]) * 100;

					weights[i] = weight.intValue();
					values[i] = Integer.valueOf(itemParts[2].substring(1));
				}

				int[][] itemMatrix = new int[numberOfItems][packageTotalWeight];
				int[][] itemChoices = new int[numberOfItems][packageTotalWeight];

				for (int i = 1; i < numberOfItems; i++) {
					for (int j = 0; j < packageTotalWeight; j++) {
						if (weights[i] <= j && (weights[i] <= j)) {
							if ((itemMatrix[i - 1][j] > (itemMatrix[i - 1][j - weights[i]] + values[i]))) {
								itemMatrix[i][j] = itemMatrix[i - 1][j];
								itemChoices[i][j] = -1;
							}
							else {
								itemMatrix[i][j] = itemMatrix[i - 1][j - weights[i]] + values[i];
								itemChoices[i][j] = 1;
							}
						}
						else {
							itemMatrix[i][j] = itemMatrix[i - 1][j];
							itemChoices[i][j] = -1;
						}
					}
				}

				List<Integer> solution = new ArrayList<Integer>();
				int totalWeightOfOptimalSolution = 0;
				int optimalValue = itemMatrix[numberOfItems - 1][packageTotalWeight - 1];

				for (int j = numberOfItems; j > 0; j--) {
					for (int i = packageTotalWeight; i > 0; i--) {
						if (itemMatrix[j - 1][i - 1] == optimalValue) {
							List<Integer> optimalSubset = new ArrayList<Integer>();

							int packageTotalWeight2 = i;
							int numberOfItems2 = j;

							while (numberOfItems2 > 0) {
								if (itemChoices[numberOfItems2 - 1][packageTotalWeight2 - 1] == 1) {
									optimalSubset.add(numberOfItems2 - 1);

									numberOfItems2--;

									packageTotalWeight2 -= weights[numberOfItems2];
								}
								else {
									numberOfItems2--;
								}
							}

							int tempWeight = 0;

							for (int optimalIndex : optimalSubset) {
								tempWeight += weights[optimalIndex];
							}

							if ((tempWeight < totalWeightOfOptimalSolution) || (totalWeightOfOptimalSolution == 0)) {
								totalWeightOfOptimalSolution = tempWeight;

								solution = optimalSubset;
							}
						}
					}
				}

				if (solution.isEmpty()) {
					System.out.println("-");
				}
				else {
					String output = "";

					Collections.sort(solution);

					for (int i = 0; i < solution.size(); i++) {
						if (output.equals("")) {
							output = output.concat(String.valueOf(solution.get(i)));
						}
						else {
							output = output + "," + String.valueOf(solution.get(i));
						}
					}

					System.out.println(output);
				}
			}
		}
	}

}