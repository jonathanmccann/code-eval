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
				String replacementCharacters = lineArray[1];

				replacementCharacters = replacementCharacters.replaceAll("\\s", "");

				for (Character c : replacementCharacters.toCharArray()) {
					lineArray[0] = lineArray[0].replace(c.toString(), "");
				}

				System.out.println(lineArray[0]);
			}
		}
	}
}