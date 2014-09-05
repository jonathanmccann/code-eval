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
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				int count = 1;
				String majorElement = "";
				int threshold = lineArray.length / 2;

				int index = 0;

				for (int i = 1; i < lineArray.length; i++) {
					if (lineArray[index].equals(lineArray[i])) {
						count++;
					}
					else {
						count--;
					}

					if (count == 0) {
						index = i;
						count = 1;
					}
				}

				majorElement = lineArray[index];

				int majorElementCount = 0;

				for (int i = 0; i < lineArray.length; i++) {
					if (lineArray[i].equals(majorElement)) {
						majorElementCount++;
					}
				}

				if (majorElementCount <= threshold) {
					System.out.println("None");
				}
				else {
					System.out.println(majorElement);
				}
			}
		}
	}
}