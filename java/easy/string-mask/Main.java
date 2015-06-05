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
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				char[] inputArray = lineArray[0].toCharArray();
				String binaryCode = lineArray[1];

				for (int i = 0; i < inputArray.length; i++) {
					if (binaryCode.charAt(i) == '1') {
						inputArray[i] = Character.toUpperCase(inputArray[i]);
					}
				}

				System.out.println(String.valueOf(inputArray));
			}
		}
	}
}