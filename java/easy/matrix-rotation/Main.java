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

			line = line.replace(" ", "");

			int length = line.length();
			int period = (int)Math.sqrt(length);
			int startingPoint = length - period;
			int characterOffset = startingPoint;

			for (int i = 0; i < length; i++) {
				sb.append(line.charAt(characterOffset));
				sb.append(" ");

				characterOffset -= period;

				if (characterOffset < 0) {
					startingPoint += 1;
					characterOffset = startingPoint;
				}
			}

			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}
}