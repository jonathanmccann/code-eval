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
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < lineArray.length; i++) {
					String word = lineArray[i];

					word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());

					sb.append(word);

					if (i != (lineArray.length - 1)) {
						sb.append(" ");
					}
				}

				System.out.println(sb.toString());
			}
		}
	}
}