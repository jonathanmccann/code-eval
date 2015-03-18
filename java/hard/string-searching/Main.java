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
			String[] lineArray = line.split(",");

			String input = lineArray[0];
			String subString = lineArray[1];

			subString = subString.replaceAll("(?=(?<!\\\\))\\*", ".*");

			Pattern subStringPattern = Pattern.compile(subString);

			Matcher matcher = subStringPattern.matcher(input);

			if (matcher.find()) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
	}
}