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
			line = line.replaceAll("\\s+", "").toLowerCase();

			boolean missingLetters = false;

			for (int i = 0; i < alphabet.length; i++) {
				if (line.indexOf(alphabet[i]) == -1) {
					System.out.print(alphabet[i]);

					missingLetters = true;
				}
			}

			if (!missingLetters) {
				System.out.print("NULL");
			}

			System.out.println();
		}
	}

	private static char[] alphabet = new char[]{
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
		'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};
}