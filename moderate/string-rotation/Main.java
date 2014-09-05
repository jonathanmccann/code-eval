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
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				boolean isRotation = false;

				if (lineArray[0].length() == lineArray[1].length()) {
					String baseString = lineArray[0];
					String rotatedString = lineArray[1];

					int pos = rotatedString.indexOf(baseString.charAt(0));

					while (pos != -1) {
						String checkString = rotatedString.substring(pos, rotatedString.length()) + rotatedString.substring(0, pos);

						if (checkString.equals(baseString)) {
							isRotation = true;

							break;
						}

						pos = rotatedString.indexOf(baseString.charAt(0), (pos + 1));
					}
				}

				if (isRotation) {
					System.out.println("True");
				}
				else {
					System.out.println("False");
				}
			}
		}
	}
}