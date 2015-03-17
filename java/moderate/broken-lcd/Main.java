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

			String[] brokenLcd = lineArray[0].split("\\s+");
			String numberToDisplay = lineArray[1];

			int numberToDisplayLength = numberToDisplay.length();

			int brokenLcdCount = 0;
			int numberToDisplayCount = 0;
			int firstDigitLcdSegment = 0;

			boolean canDisplayDigit = false;
			boolean canDisplayDecimal = false;
			boolean nextDecimal = false;

			while (true) {
				canDisplayDigit = digitCanBeDisplayed(
					brokenLcd[brokenLcdCount],
					_BIT_MAP.get(numberToDisplay.charAt(numberToDisplayCount)));

				if ((numberToDisplayCount != numberToDisplayLength - 1) &&
					numberToDisplay.charAt(numberToDisplayCount + 1) == '.') {

					nextDecimal = true;

					canDisplayDecimal =
						digitCanBeDisplayed(brokenLcd[brokenLcdCount],
						_BIT_MAP.get('.'));
				}
				else {
					nextDecimal = false;
				}

				if (nextDecimal && canDisplayDecimal && canDisplayDigit) {
					brokenLcdCount++;
					numberToDisplayCount += 2;
				}
				else if (canDisplayDigit) {
					brokenLcdCount++;
					numberToDisplayCount++;
				}
				else {
					numberToDisplayCount = 0;
					firstDigitLcdSegment++;
					brokenLcdCount = firstDigitLcdSegment;
				}

				if (numberToDisplayCount == numberToDisplayLength) {
					System.out.println("1");

					break;
				}
				else if (brokenLcdCount >= brokenLcd.length) {
					System.out.println("0");

					break;
				}
			}
		}
	}

	private static boolean digitCanBeDisplayed(
		String lcdSegments, int[] bitsToCheck) {

		for (int bitToCheck : bitsToCheck) {
			if (lcdSegments.charAt(bitToCheck) != '1') {
				return false;
			}
		}

		return true;
	}

	private static final Map<Character, int[]> _BIT_MAP;

	static {
		Map<Character, int[]> digitBits = new HashMap<>();

		digitBits.put('1', new int[]{ 1, 2 });
		digitBits.put('2', new int[]{ 0, 1, 3, 4, 6 });
		digitBits.put('3', new int[]{ 0, 1, 2, 3, 6 });
		digitBits.put('4', new int[]{ 1, 2, 5, 6 });
		digitBits.put('5', new int[]{ 0, 2, 3, 5, 6 });
		digitBits.put('6', new int[]{ 0, 2, 3, 4, 5, 6 });
		digitBits.put('7', new int[]{ 0, 1, 2});
		digitBits.put('8', new int[]{ 0, 1, 2, 3, 4, 5, 6 });
		digitBits.put('9', new int[]{ 0, 1, 2, 3, 5, 6 });
		digitBits.put('0', new int[]{ 0, 1, 2, 3, 4, 5 });
		digitBits.put('.', new int[]{ 7 });

		_BIT_MAP = digitBits;
	}
}