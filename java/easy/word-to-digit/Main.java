import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				StringBuilder sb = new StringBuilder(lineArray.length);

				for (String word: lineArray) {
					sb.append(_wordToDigitMap.get(word));
				}

				System.out.println(sb.toString());
			}
		}
	}

	private static final Map<String, String> _wordToDigitMap =
		new HashMap<String, String>() {};

	static {
		_wordToDigitMap.put("zero", "0");
		_wordToDigitMap.put("one", "1");
		_wordToDigitMap.put("two", "2");
		_wordToDigitMap.put("three", "3");
		_wordToDigitMap.put("four", "4");
		_wordToDigitMap.put("five", "5");
		_wordToDigitMap.put("six", "6");
		_wordToDigitMap.put("seven", "7");
		_wordToDigitMap.put("eight", "8");
		_wordToDigitMap.put("nine", "9");
	}
}