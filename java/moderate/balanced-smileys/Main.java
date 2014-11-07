import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			int balance = 0;

			if (line.startsWith(")")) {
				System.out.println("NO");
			}
			else {
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '(') {
						balance++;
					}
					else if (line.charAt(i) == ')') {
						balance--;
					}
				}

				int numberOfSadSmileys = numberOfSmileys(line, sadSmiley);
				int numberOfHappySmileys = numberOfSmileys(line, happySmiley);

				/*if (balance > 0) {
					if (numberOfSmileys(line, sadSmiley) == balance) {
						balance = 0;
					}
				}
				else if (balance < 0) {
					if (numberOfSmileys(line, happySmiley) == (balance * -1)) {
						balance = 0;
					}
				}*/

				if (balance != 0) {
					balance = balance + numberOfHappySmileys - numberOfSadSmileys;
				}

				if (balance == 0) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}

	private static int numberOfSmileys(String input, Pattern pattern) {
		int count = 0;

		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			count++;
		}

		return count;
	}

	private static Pattern happySmiley = Pattern.compile(":\\)");
	private static Pattern sadSmiley = Pattern.compile(":\\(");
}