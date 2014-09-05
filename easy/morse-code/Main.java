import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+\\s+");

			if (lineArray.length > 0) {
				for (int i = 0; i < lineArray.length; i++) {
					StringBuilder sb = new StringBuilder();

					String[] wordArray = lineArray[i].split("\\s+");

					for (String s : wordArray) {
						sb.append(_morseCode.get(s));
					}

					if (i != (lineArray.length - 1)) {
						sb.append(" ");
					}

					System.out.print(sb.toString());
				}

				System.out.println();
			}
		}
	}

	private static final HashMap<String, String> _morseCode = new HashMap<String, String>();

	static {
		_morseCode.put(".-", "A");
		_morseCode.put("-...", "B");
		_morseCode.put("-.-.", "C");
		_morseCode.put("-..", "D");
		_morseCode.put(".", "E");
		_morseCode.put("..-.", "F");
		_morseCode.put("--.", "G");
		_morseCode.put("....", "H");
		_morseCode.put("..", "I");
		_morseCode.put(".---", "J");
		_morseCode.put("-.-", "K");
		_morseCode.put(".-..", "L");
		_morseCode.put("--", "M");
		_morseCode.put("-.", "N");
		_morseCode.put("---", "O");
		_morseCode.put(".--.", "P");
		_morseCode.put("--.-", "Q");
		_morseCode.put(".-.", "R");
		_morseCode.put("...", "S");
		_morseCode.put("-", "T");
		_morseCode.put("..-", "U");
		_morseCode.put("...-", "V");
		_morseCode.put(".--", "W");
		_morseCode.put("-..-", "X");
		_morseCode.put("-.--", "Y");
		_morseCode.put("--..", "Z");
		_morseCode.put(".----", "1");
		_morseCode.put("..---", "2");
		_morseCode.put("...--", "3");
		_morseCode.put("....-", "4");
		_morseCode.put(".....", "5");
		_morseCode.put("-....", "6");
		_morseCode.put("--...", "7");
		_morseCode.put("---..", "8");
		_morseCode.put("----.", "9");
		_morseCode.put("-----", "0");
	};
}