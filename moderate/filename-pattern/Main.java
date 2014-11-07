import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				String regularExpression = lineArray[0];

				regularExpression = regularExpression.replaceAll("\\.", "\\\\.");
				regularExpression = regularExpression.replaceAll("\\?", ".");
				regularExpression = regularExpression.replaceAll("\\*", ".*");

				Pattern pattern = Pattern.compile(regularExpression);

				StringBuilder sb = new StringBuilder(lineArray.length - 1);

				for (int i = 1; i < lineArray.length; i++) {
					if (pattern.matcher(lineArray[i]).matches()) {
						sb.append(lineArray[i] + " ");
					}
				}

				if (sb.length() > 0) {
					sb.setLength(sb.length() - 1);

					System.out.println(sb.toString());
				}
				else {
					System.out.println("-");
				}
			}
		}
	}
}