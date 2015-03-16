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
			Matcher matcher = _emailAddressPattern.matcher(line);

			if (matcher.find()) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
	}

	private static final Pattern _emailAddressPattern =
		Pattern.compile("^[a-zA-Z0-9\\.\\+_-]*\\@\\w+\\.\\w+");
}