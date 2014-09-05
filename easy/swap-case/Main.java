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
			char[] characters = line.toCharArray();

			for (int i = 0; i < characters.length; i++) {
				char c = characters[i];

				if (Character.isUpperCase(c)) {
					characters[i] = Character.toLowerCase(c);
				}
				else if (Character.isLowerCase(c)) {
					characters[i] = Character.toUpperCase(c);
				}
			}

			System.out.println(new String(characters));
		}
	}
}