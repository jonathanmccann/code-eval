import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		char[][] characterArray = new char[50][12];

		int count = 0;

		while ((line = in.readLine()) != null) {
			characterArray[count] = line.toCharArray();

			count++;
		}

		int startingPoint = -1;

		for (int i = 0; i < characterArray[0].length; i++) {
			if (characterArray[0][i] == _GATE) {
				startingPoint = i;

				characterArray[0][startingPoint] = '|';

				break;
			}
		}

		char left = ' ';
		char straight = ' ';
		char right= ' ';

		for (int i = 1; i < characterArray.length; i++) {
			char[] charArray = characterArray[i];

			// Get the left, straight, and right routes
			if (startingPoint > 0) {
				left = charArray[startingPoint - 1];
			}

			straight = charArray[startingPoint];

			if (startingPoint < 11) {
				right = charArray[startingPoint + 1];
			}

			// Test to see if route is a checkpoint
			if (left == _CHECKPOINT) {
				characterArray[i][startingPoint - 1] = '/';
				startingPoint--;

				continue;
			}
			else if (straight == _CHECKPOINT) {
				characterArray[i][startingPoint] = '|';

				continue;
			}
			else if (right == _CHECKPOINT) {
				characterArray[i][startingPoint + 1] = '\\';
				startingPoint++;

				continue;
			}

			// Test to see if route is a gate
			if (left == _GATE) {
				characterArray[i][startingPoint - 1] = '/';
				startingPoint--;
			}
			else if (straight == _GATE) {
				characterArray[i][startingPoint] = '|';
			}
			else if (right == _GATE) {
				characterArray[i][startingPoint + 1] = '\\';
				startingPoint++;
			}
		}

		for (int i = 0; i < characterArray.length; i++) {
			for (int j = 0; j < characterArray[i].length; j++) {
				System.out.print(characterArray[i][j]);
			}

			System.out.println();
		}
	}

	private static char _CHECKPOINT = 'C';

	private static char _GATE = '_';
}