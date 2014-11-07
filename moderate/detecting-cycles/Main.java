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

			int count = 1;

			if (lineArray.length > 0) {
				for (int i = 0; i < lineArray.length; i++) {
					if ((i + count) > lineArray.length) {
						System.out.println("No cycle");

						break;
					}
					else if (lineArray[i].equals(lineArray[i + count])) {
						for (int j = i; j < (i + count); j++) {
							System.out.print(lineArray[j] + " ");
						}

						System.out.println();

						break;
					}

					count++;
				}
			}
		}
	}
}