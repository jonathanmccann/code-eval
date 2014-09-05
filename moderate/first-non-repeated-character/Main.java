import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<Character> nonRepeatedCharacters = new LinkedList<Character>();
			List<Character> repeatedCharacters = new LinkedList<Character>();

			char[] charArray = line.toCharArray();

			for (char c : charArray) {
				if (!nonRepeatedCharacters.contains(c)) {
					nonRepeatedCharacters.add(c);
				}
				else {
					repeatedCharacters.add(c);
				}
			}

			nonRepeatedCharacters.removeAll(repeatedCharacters);

			System.out.println(nonRepeatedCharacters.get(0));
		}
	}
}