import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				Arrays.sort(lineArray);

				String previousElement = lineArray[0];

				int count = 1;
				int majorElement = 0;
				int threshold = lineArray.length / 2;

				for (int i = 1; i < lineArray.length; i++) {
					if (previousElement.equals(lineArray[i])) {
						count++;

						if (count > threshold) {
							majorElement = Integer.valueOf(lineArray[i]);

							break;
						}
					}
					else {
						previousElement = lineArray[i];
						count = 1;
					}
				}

				if (majorElement == 0) {
					System.out.println("None");
				}
				else {
					System.out.println(majorElement);
				}
			}
		}
	}
}