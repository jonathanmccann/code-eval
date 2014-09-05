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
			char[] charArray = line.toCharArray();

			if (charArray.length > 0) {
				int totalNumber = charArray.length;

				double totalSum = 0;

				for (int i = 0; i < totalNumber; i++) {
					totalSum = totalSum + Math.pow(
						Character.getNumericValue(charArray[i]), totalNumber);
				}

				if (String.valueOf((int)totalSum).equals(line)) {
					System.out.println("True");
				}
				else {
					System.out.println("False");
				}
			}
		}
	}
}