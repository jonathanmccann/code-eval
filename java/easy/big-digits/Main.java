import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<Integer> digits = new ArrayList<Integer>();

			for (Character c : line.toCharArray()) {
				if (Character.isDigit(c)) {
					digits.add(Character.getNumericValue(c));
				}
			}

			for (int i = 0; i < 6; i++) {
				for (int digit : digits) {
					String[] text = digitToTextArray[digit];

					System.out.print(text[i]);
				}

				System.out.println();
			}
		}
	}

	private static String[][] digitToTextArray = {
		{"-**--", "*--*-", "*--*-", "*--*-", "-**--", "-----"},
		{"--*--", "-**--", "--*--", "--*--", "-***-", "-----"},
		{"***--", "---*-", "-**--", "*----", "****-", "-----"},
		{"***--", "---*-", "-**--", "---*-", "***--", "-----"},
		{"-*---", "*--*-", "****-", "---*-", "---*-", "-----"},
		{"****-", "*----", "***--", "---*-", "***--", "-----"},
		{"-**--", "*----", "***--", "*--*-", "-**--", "-----"},
		{"****-", "---*-", "--*--", "-*---", "-*---", "-----"},
		{"-**--", "*--*-", "-**--", "*--*-", "-**--", "-----"},
		{"-**--", "*--*-", "-***-", "---*-", "-**--", "-----"},
	};
}