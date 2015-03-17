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
			String[] lineArray = line.split(";");

			String key = lineArray[0];
			String encipheredMessage = lineArray[1];

			int keyCount = 0;

			StringBuilder sb = new StringBuilder(encipheredMessage.length());

			for (Character c : encipheredMessage.toCharArray()) {
				int offset = Character.getNumericValue(key.charAt(keyCount));

				int positionOfCharacter = _ALPHABET.indexOf(c);

				int newPosition = positionOfCharacter - offset;

				if (newPosition < 0) {
					newPosition = 84 + newPosition;
				}

				sb.append(_ALPHABET.charAt(newPosition));

				keyCount++;

				if (keyCount > (key.length() - 1)) {
					keyCount = 0;
				}
			}

			System.out.println(sb.toString());
		}
	}

	private static final String _ALPHABET =
		" !\"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
}