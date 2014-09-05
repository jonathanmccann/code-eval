import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		boolean foundChar = true;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				String string = lineArray[0];
				char c = lineArray[1].charAt(0);

				char[] charArray = string.toCharArray();

				for (int i = charArray.length - 1; i >= 0; i--) {
					if (charArray[i] == c) {
						System.out.println(i);

						foundChar = true;

						break;
					}
					else {
						foundChar = false;
					}
				}
			}

			if (!foundChar) {
				System.out.println(-1);
			}
		}
	}
}