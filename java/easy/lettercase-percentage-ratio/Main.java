import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			double lowercaseCount = 0;
			double uppercaseCount = 0;

			for (Character c : line.toCharArray()) {
				if (Character.isLowerCase(c)) {
					lowercaseCount++;
				}
				else {
					uppercaseCount++;
				}
			}

			DecimalFormat df = new DecimalFormat("0.00");

			double lowercaseRatio = (lowercaseCount / line.length()) * 100;
			double uppercaseRatio = (uppercaseCount / line.length()) * 100;

			System.out.println("lowercase: " + df.format(lowercaseRatio) + " uppercase: " + df.format(uppercaseRatio));
		}
	}
}