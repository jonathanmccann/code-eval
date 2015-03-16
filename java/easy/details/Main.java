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

			int numberOfCellsToMove = 0;

			if (lineArray.length > 0) {
				for (String input : lineArray) {
					Matcher matcher = _cavityPattern.matcher(input);

					if (matcher.find()) {
						int inputLength = matcher.group(1).length();

						if (numberOfCellsToMove == 0) {
							numberOfCellsToMove = inputLength;
						}
						else if (inputLength < numberOfCellsToMove) {
							numberOfCellsToMove = inputLength;
						}
					}
					else {
						numberOfCellsToMove = 0;

						break;
					}
				}

				System.out.println(numberOfCellsToMove);
			}
		}
	}

	private static final Pattern _cavityPattern =
		Pattern.compile("(?:X)(\\.+)(?:Y)");
}