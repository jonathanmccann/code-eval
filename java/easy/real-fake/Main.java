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
			String creditCardNumber = line.replaceAll(" ", "");

			int total = 0;

			for (int i = 0; i < creditCardNumber.length(); i++) {
				if (i % 2 == 0) {
					total += Character.getNumericValue(creditCardNumber.charAt(i)) * 2;
				}
				else {
					total += Character.getNumericValue(creditCardNumber.charAt(i));
				}
			}

			if (total % 10 == 0) {
				System.out.println("Real");
			}
			else {
				System.out.println("Fake");
			}
		}
	}
}