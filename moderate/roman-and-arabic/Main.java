import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			int total = 0;

			for (int i = 0; i < line.length(); i+=2) {
				int arabicDigit = Character.getNumericValue(line.charAt(i));
				Character romanNumeral = line.charAt(i + 1);

				if (((i + 3) > line.length()) || (romanNumeralMap.get(romanNumeral) >= romanNumeralMap.get(line.charAt(i + 3)))) {
					total += arabicDigit * romanNumeralMap.get(romanNumeral);
				}
				else {
					total -= arabicDigit * romanNumeralMap.get(romanNumeral);
				}
			}

			System.out.println(total);
		}
	}

	private static final Map<Character, Integer> romanNumeralMap;

	static {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		romanNumeralMap = Collections.unmodifiableMap(map);
	}
}