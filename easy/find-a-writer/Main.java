import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\|");

			StringBuilder sb = new StringBuilder();

			if (lineArray.length > 0) {
				char[] letters = lineArray[0].toCharArray();

				String[] key = lineArray[1].trim().split("\\s+");

				for (String s : key) {
					int keyValue = Integer.parseInt(s);

					sb.append(letters[keyValue - 1]);
				}

				System.out.println(sb.toString());
			}
		}
	}
}