import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<Character> digits = new ArrayList<Character>();

			for (int i = 0; i < line.length(); i++) {
				Character c = line.charAt(i);

				if (Character.isDigit(c)) {
					digits.add(c);
				}
			}

			for (int i = 0; i < 6; i++) {
				for (Character digit : digits) {
					String[] text = digitToTextMap.get(digit);

					System.out.print(text[i]);
				}

				System.out.println();
			}
		}
	}

	private static Map<Character, String[]> digitToTextMap;

	private static String[] _zero = {
		"-**--", "*--*-", "*--*-", "*--*-", "-**--", "-----"
	};

	private static String[] _one = {
		"--*--", "-**--", "--*--", "--*--", "-***-", "-----"
	};

	private static String[] _two = {
		"***--", "---*-", "-**--", "*----", "****-", "-----"
	};

	private static String[] _three = {
		"***--", "---*-", "-**--", "---*-", "***--", "-----"
	};

	private static String[] _four = {
		"-*---", "*--*-", "****-", "---*-", "---*-", "-----"
	};

	private static String[] _five = {
		"****-", "*----", "***--", "---*-", "***--", "-----"
	};

	private static String[] _six = {
		"-**--", "*----", "***--", "*--*-", "-**--", "-----"
	};

	private static String[] _seven = {
		"****-", "---*-", "--*--", "-*---", "-*---", "-----"
	};

	private static String[] _eight = {
		"-**--", "*--*-", "-**--", "*--*-", "-**--", "-----"
	};

	private static String[] _nine = {
		"-**--", "*--*-", "-***-", "---*-", "-**--", "-----"
	};

	static {
		Map<Character, String[]> myMap = new HashMap<Character, String[]>();

		myMap.put('0', _zero);
		myMap.put('1', _one);
		myMap.put('2', _two);
		myMap.put('3', _three);
		myMap.put('4', _four);
		myMap.put('5', _five);
		myMap.put('6', _six);
		myMap.put('7', _seven);
		myMap.put('8', _eight);
		myMap.put('9', _nine);

		digitToTextMap = Collections.unmodifiableMap(myMap);
	}
}
