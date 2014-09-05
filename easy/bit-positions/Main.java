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
				int number = Integer.parseInt(lineArray[0]);
				int firstPosition = Integer.parseInt(lineArray[1]);
				int secondPosition = Integer.parseInt(lineArray[2]);

				boolean isSameBit = (((number >> (firstPosition - 1)) & 1) == ((number >> (secondPosition - 1)) & 1));

				System.out.println(isSameBit);
			}
		}
	}
}