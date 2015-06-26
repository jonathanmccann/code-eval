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

			String longestWord = "";
			int longestWordLength = 0;

			if (lineArray.length > 0) {
				for (String input : lineArray) {
					if (input.length() > longestWordLength) {
						longestWord = input;

						longestWordLength = input.length();
					}
				}

				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < longestWordLength; i++) {
					char c = longestWord.charAt(i);

					for (int j = 0; j < i; j++) {
						sb.append("*");
					}

					sb.append(c);
					sb.append(" ");
				}

				System.out.println(sb.toString());
			}
		}
	}
}