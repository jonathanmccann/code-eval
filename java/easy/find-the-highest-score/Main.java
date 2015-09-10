import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\|");

			List<List<String>> inputList = new ArrayList<>();

			for (String input : lineArray) {
				inputList.add(Arrays.asList(input.trim().split("\\s+")));
			}

			int numberOfCategories = inputList.get(0).size();

			StringBuilder sb = new StringBuilder(numberOfCategories);

			for (int i = 0; i < numberOfCategories; i++) {
				int highestScore = -1001;

				for (List<String> participantScores : inputList) {
					int score = Integer.valueOf(participantScores.get(i));

					if (score > highestScore) {
						highestScore = score;
					}
				}

				sb.append(highestScore + " ");
			}

			System.out.println(sb.toString().trim());
		}
	}
}