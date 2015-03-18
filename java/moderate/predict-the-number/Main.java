import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		StringBuilder sb = new StringBuilder();

		sb.append("0");

		while ((line = in.readLine()) != null) {
			int position = Integer.valueOf(line);

			while (sb.length() < position) {
				for (Character c : sb.toString().toCharArray()) {
					int digit = Character.getNumericValue(c);

					if (digit == 2) {
						digit = 0;
					}
					else {
						digit++;
					}

					sb.append(digit);
				}
			}

			System.out.println(sb.charAt(position));
		}
	}
}