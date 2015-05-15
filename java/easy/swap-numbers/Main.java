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
			String[] lineArray = line.split("\\s+");

			int lineArrayLength = lineArray.length;

			for (int i = 0; i < lineArrayLength; i++) {
				String input = lineArray[i];

				StringBuilder sb = new StringBuilder(4);

				int lastCharacterPosition = input.length() - 1;

				sb.append(input.charAt(lastCharacterPosition));
				sb.append(input.substring(1, lastCharacterPosition));
				sb.append(input.charAt(0));

				if ((i + 1) != lineArrayLength) {
					sb.append(" ");
				}

				System.out.print(sb.toString());
			}

			System.out.println();
		}
	}
}