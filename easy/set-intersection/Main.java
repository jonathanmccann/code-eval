import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<String> listOfNumbers = Arrays.asList(line.split(";"));

			List<String> firstList = Arrays.asList(listOfNumbers.get(0).split(","));

			List<String> secondList = Arrays.asList(listOfNumbers.get(1).split(","));

			StringBuilder sb = new StringBuilder(listOfNumbers.size());

			for (int i = 0; i < firstList.size(); i++) {
				if (secondList.contains(firstList.get(i))) {
					if (sb.length() != 0) {
						sb.append("," + firstList.get(i));
					}
					else {
						sb.append(firstList.get(i));
					}
				}
			}

			System.out.println(sb.toString());
		}
	}
}