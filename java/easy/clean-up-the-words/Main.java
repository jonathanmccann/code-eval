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
			Matcher matcher = _WORD_PATTERN.matcher(line);

			StringBuilder sb = new StringBuilder();

			while (matcher.find()) {
				sb.append(matcher.group().toLowerCase());
				sb.append(" ");
			}

			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}

	private static final Pattern _WORD_PATTERN = Pattern.compile("([a-zA-Z]+)");

}