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
				StringBuilder sb = new StringBuilder();

				String[] stringDigits = lineArray[0].split(",");

				Integer[] integerDigits = new Integer[stringDigits.length];

				int sum = Integer.valueOf(lineArray[1]);
				int digitsCount = 1;

				for (int i = 0; i < stringDigits.length; i++) {
					integerDigits[i] = Integer.valueOf(stringDigits[i]);
				}

				for (int i = 0; i < integerDigits.length; i++) {
					for (int j = digitsCount; j < integerDigits.length; j++) {
						int temporarySum = Integer.valueOf(integerDigits[i]) + Integer.valueOf(integerDigits[j]);

						if (temporarySum == sum) {
							if (!sb.toString().isEmpty()) {
								sb.append(";");
							}

							sb.append(Integer.valueOf(integerDigits[i]));
							sb.append(",");
							sb.append(Integer.valueOf(integerDigits[j]));
						}
					}

					digitsCount++;
				}

				if (!sb.toString().isEmpty()) {
					System.out.println(sb.toString());
				}
				else {
					System.out.println("NULL");
				}
			}
		}
	}
}