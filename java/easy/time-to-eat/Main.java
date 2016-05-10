import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				SortedSet<String> timestamps = new TreeSet<>(Collections.reverseOrder());

				for (int i = 0; i < lineArray.length; i++) {
					timestamps.add(lineArray[i]);
				}

				StringBuilder sb = new StringBuilder(timestamps.size() * 2);

				for (String timestamp : timestamps) {
					sb.append(timestamp);
					sb.append(" ");
				}

				sb.setLength(sb.length() - 1);

				System.out.println(sb.toString());
			}
		}
	}
}