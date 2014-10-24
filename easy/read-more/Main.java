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
			String output = line;

			if (line.length() > _MAXIMUM_LINE_LENGTH) {
				output = line.substring(0, _SUBSTRING_LENGTH);

				if (line.charAt(_SUBSTRING_LENGTH) != ' ') {
					int lastIndex = output.lastIndexOf(" ");

					if (lastIndex > 0) {
						output = output.substring(0, lastIndex);
					}
				}

				output = output.trim();

				output = output.concat(_READ_MORE);
			}

			System.out.println(output);
		}
	}

	private static final int _MAXIMUM_LINE_LENGTH = 55;
	private static final int _SUBSTRING_LENGTH = 40;

	private static final String _READ_MORE = "... <Read More>";
}