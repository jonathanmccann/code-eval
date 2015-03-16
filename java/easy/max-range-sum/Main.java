import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			int numberOfDays = Integer.valueOf(lineArray[0]);

			String[] gainOrLossArray = lineArray[1].split("\\s+");

			List<Integer> gainOrLossList = new ArrayList<>();

			for (String gainOrLoss : gainOrLossArray) {
				gainOrLossList.add(Integer.valueOf(gainOrLoss));
			}

			int numberOfPossibleArrays = gainOrLossList.size() - numberOfDays + 1;

			int maxSum = 0;
			int count = 0;

			while (count < numberOfPossibleArrays) {
				int sum = 0;

				for (int i = count; i < (numberOfDays + count); i++) {
					sum += gainOrLossList.get(i);
				}

				if (sum > maxSum) {
					maxSum = sum;
				}

				count++;
			}

			System.out.println(maxSum);
		}
	}
}