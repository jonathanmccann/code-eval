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

				List<Integer> optimalSubset = new ArrayList<Integer>();

				while (numberOfItems > 0) {
					if (itemChoices[numberOfItems - 1][packageTotalWeight - 1] == 1) {
						optimalSubset.add(numberOfItems - 1);

						numberOfItems--;

						packageTotalWeight -= weights[numberOfItems];
					}
					else {
						numberOfItems--;
					}
				}

				List<Integer> optimalSubsetMinimizedWeight = new ArrayList<Integer>(optimalSubset);

				for (int optimal : optimalSubset) {
					for (int i = 1; i < values.length; i++) {
						if ((values[i] == values[optimal]) && (weights[i] < weights[optimal]) && !optimalSubsetMinimizedWeight.contains(i)) {
							optimalSubsetMinimizedWeight.remove((Object)optimal);
							optimalSubsetMinimizedWeight.add(i);
						}
					}
				}

				if (optimalSubsetMinimizedWeight.isEmpty()) {
					System.out.println("-");
				}
				else {
					String output = "";

					Collections.sort(optimalSubsetMinimizedWeight);

					for (int i = 0; i < optimalSubsetMinimizedWeight.size(); i++) {
						if (output.equals("")) {
							output = output.concat(String.valueOf(optimalSubsetMinimizedWeight.get(i)));
						}
						else {
							output = output + "," + String.valueOf(optimalSubsetMinimizedWeight.get(i));
						}
					}

					System.out.println(output);
				}
			}
		}
	}

}