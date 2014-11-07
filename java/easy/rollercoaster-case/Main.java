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
			StringBuilder sb = new StringBuilder(line.length());

			boolean toUppercase = true;

			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);

				if (Character.isLetter(c)) {
					if ((c >= 97) && (c <= 122) && toUppercase) {
						c -= 32;
					}
					else if ((c >= 65) && (c <= 90) && !toUppercase) {
						c += 32;
					}

					toUppercase = !toUppercase;
				}

				sb.append(c);
			}

			System.out.println(sb.toString());
		}
	}
}