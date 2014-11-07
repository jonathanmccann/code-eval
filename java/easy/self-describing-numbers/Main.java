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
			boolean selfDescribingNumber = true;

			char[] charArray = line.toCharArray();

			int counter = _asciiZero;

			for (int i = 0; i < charArray.length; i++) {
				int numberRepetition = Character.getNumericValue(charArray[i]);

				int index = 0;

				for (int j = 0; j < numberRepetition; j++) {
					index = line.indexOf((char) counter, index);

					if (index == -1) {
						selfDescribingNumber = false;

						break;
					}
				}

				if (!selfDescribingNumber) {
					System.out.println(0);

					break;
				}

				counter++;
			}

			if (selfDescribingNumber) {
				System.out.println(1);
			}
		}
	}

	private static final int _asciiZero = 48;
}