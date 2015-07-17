import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			int arrowCounter = 0;

			Matcher matcher = _LEFT_ARROW_PATTERN.matcher(line);

			boolean arrowFound = matcher.find();

			while (arrowFound) {
				arrowCounter++;

				arrowFound = matcher.find(matcher.start() + 1);
			}

			matcher = _RIGHT_ARROW_PATTERN.matcher(line);

			arrowFound = matcher.find();

			while (arrowFound) {
				arrowCounter++;

				arrowFound = matcher.find(matcher.start() + 1);
			}

			System.out.println(arrowCounter);
		}
	}

	private static final Pattern _LEFT_ARROW_PATTERN = Pattern.compile("<--<<");
	private static final Pattern _RIGHT_ARROW_PATTERN =
		Pattern.compile(">>-->");

}