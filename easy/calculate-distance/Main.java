import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				List<Integer> coordinates = new LinkedList<Integer>();

				for (int i = 0; i < lineArray.length; i++) {
					coordinates.add(parseInteger(lineArray[i]));
				}

				System.out.println(calculateDistance(coordinates));
			}
		}
	}

	private static int calculateDistance(List<Integer> coordinates) {
		int x1 = coordinates.get(0);
		int y1 = coordinates.get(1);
		int x2 = coordinates.get(2);
		int y2 = coordinates.get(3);

		return (int)Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	private static int parseInteger(String integerString) {
		return Integer.parseInt(integerString.replace("(", "").replace(")", "").replace(",", ""));
	}
}