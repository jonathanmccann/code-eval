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
				int index = 0;

				for (int i = 1; i < lineArray.length; i++) {
					if (lineArray[index].length() < lineArray[i].length()) {
						index = i;
					}
				}

				System.out.println(lineArray[index]);
			}
		}
	}
}