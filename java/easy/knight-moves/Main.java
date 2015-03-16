import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<String> possiblePositions = new ArrayList<>();

			char[] characters = line.toCharArray();

			// Check left

			checkHorizontal(characters, possiblePositions, -2);

			// Check Right

			checkHorizontal(characters, possiblePositions, 2);

			// Check Up

			checkVertical(characters, possiblePositions, 2);

			// Check down

			checkVertical(characters, possiblePositions, -2);

			Collections.sort(possiblePositions);

			StringBuilder sb = new StringBuilder(possiblePositions.size() * 2);

			for (String possiblePosition : possiblePositions) {
				sb.append(possiblePosition);
				sb.append(" ");
			}

			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}

	private static void checkHorizontal(
		char[] characters, List<String> possiblePositions, int offset) {

		Character letterPosition = (char)(characters[0] + offset);

		if ((letterPosition >= _LETTER_LOWER_BOUND) &&
			(letterPosition <= _LETTER_UPPER_BOUND)) {

			Character numberPosition = (char)(characters[1] - 1);

			if ((numberPosition >= _NUMBER_LOWER_BOUND) &&
				(numberPosition <= _NUMBER_UPPER_BOUND)) {

				possiblePositions.add(
					letterPosition.toString() + numberPosition.toString());
			}

			numberPosition = (char)(characters[1] + 1);

			if ((numberPosition >= _NUMBER_LOWER_BOUND) &&
				(numberPosition <= _NUMBER_UPPER_BOUND)) {

				possiblePositions.add(
					letterPosition.toString() + numberPosition.toString());
			}
		}
	}

	private static void checkVertical(
		char[] characters, List<String> possiblePositions, int offset) {

		Character numberPosition = (char)(characters[1] + offset);

		if ((numberPosition >= _NUMBER_LOWER_BOUND) &&
			(numberPosition <= _NUMBER_UPPER_BOUND)) {

			Character letterPosition = (char)(characters[0] - 1);

			if ((letterPosition >= _LETTER_LOWER_BOUND) &&
				(letterPosition <= _LETTER_UPPER_BOUND)) {

				possiblePositions.add(
					letterPosition.toString() + numberPosition.toString());
			}

			letterPosition = (char)(characters[0] + 1);

			if ((letterPosition >= _LETTER_LOWER_BOUND) &&
				(letterPosition <= _LETTER_UPPER_BOUND)) {

				possiblePositions.add(
					letterPosition.toString() + numberPosition.toString());
			}
		}
	}

	private static final int _LETTER_LOWER_BOUND = 97;
	private static final int _LETTER_UPPER_BOUND = 104;
	private static final int _NUMBER_LOWER_BOUND = 49;
	private static final int _NUMBER_UPPER_BOUND = 56;
}