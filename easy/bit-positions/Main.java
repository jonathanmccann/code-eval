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
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				String bitString = Integer.toBinaryString(Integer.valueOf(lineArray[0]));

				char[] charArray = bitString.toCharArray();

				int firstPosition = Integer.valueOf(lineArray[1]) - 1;
				int secondPosition = Integer.valueOf(lineArray[2]) - 1;

				if (charArray[firstPosition] == charArray[secondPosition]) {
					System.out.println("true");
				}
				else {
					System.out.println("false");
				}
			}
		}
	}
}