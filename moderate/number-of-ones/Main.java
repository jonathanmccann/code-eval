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
			String bitString = Integer.toBinaryString(Integer.valueOf(line));

			char[] charArray = bitString.toCharArray();

			int counter = 0;

			for (char c : charArray) {
				if (c == '1') {
					counter++;
				}
			}

			System.out.println(counter);
		}
	}
}