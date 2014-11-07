import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				String output = "";

				String[] stringDigits = lineArray[0].split(",");

				int sum = Integer.valueOf(lineArray[1]);

				Map<Integer, Integer> summationMap =
					new HashMap<Integer, Integer>();

				for (String digit : stringDigits) {
					int integerDigit = Integer.valueOf(digit);

					if (summationMap.containsKey(integerDigit)) {
						output =
							String.valueOf(summationMap.get(integerDigit)) + ","
								+ digit + ";" + output;
					}
					else {
						summationMap.put((sum - integerDigit), integerDigit);
					}
				}

				if (output.isEmpty()) {
					System.out.println("NULL");
				}
				else {
					System.out.println(output.substring(0, output.length() - 1));
				}
			}
		}
	}
}