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
			StringBuilder sb = new StringBuilder();

			Matcher matcher = _repeatedCharacterPattern.matcher(line);

			int index = 0;

			while (matcher.find()) {
				sb.append(line.substring(index, matcher.start()));
				sb.append(matcher.group().substring(0, 1));

				index = matcher.start() + matcher.group().length();
			}

			sb.append(line.substring(index));

			System.out.println(sb.toString());
		}
	}

	private static Pattern _repeatedCharacterPattern =
		Pattern.compile("(.)\\1{1,}");

}