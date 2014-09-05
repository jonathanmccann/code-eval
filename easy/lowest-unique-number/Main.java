import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<String> lineArray = Arrays.asList(line.split("\\s+"));

			List<String> uniqueIntegers = new ArrayList<String>();
			List<String> duplicateIntegers = new ArrayList<String>();

			if (lineArray.size() > 0) {
				for (String integer : lineArray) {
					if (duplicateIntegers.contains(integer)) {
						uniqueIntegers.remove(integer);
					}
					else if (uniqueIntegers.contains(integer)) {
						uniqueIntegers.remove(integer);
						duplicateIntegers.add(integer);
					}
					else {
						uniqueIntegers.add(integer);
					}
				}

				int lowestUniqueNumber = 0;

				for (String integer : uniqueIntegers) {
					if (lowestUniqueNumber == 0 || Integer.valueOf(integer) < lowestUniqueNumber) {
						lowestUniqueNumber = Integer.valueOf(integer);
					}
				}

				int winningPlayer = 0;

				if (lowestUniqueNumber > 0) {
					winningPlayer = lineArray.indexOf(Integer.toString(lowestUniqueNumber)) + 1;
				}

				System.out.println(winningPlayer);
			}
		}
	}
}