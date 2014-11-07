import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				int numberOfLocks = Integer.valueOf(lineArray[0]);
				int numberOfPasses = Integer.valueOf(lineArray[1]);

				String[] doors = new String[numberOfLocks];

				Arrays.fill(doors, "Unlocked");

				for (int i = 1; i <= numberOfPasses; i++) {
					if (i == numberOfPasses) {
						// Lock only the last door
						if (doors[numberOfLocks - 1].equals("Locked")) {
							doors[numberOfLocks - 1] = "Unlocked";
						}
						else {
							doors[numberOfLocks - 1] = "Locked";
						}

						break;
					}

					// First: Ever second door is locked
					for (int j = 1; j < numberOfLocks; j+=2) {
						doors[j] = "Locked";
					}

					// Second: Every third door's lock is switched
					for (int j = 2; j < numberOfLocks; j+=3) {
						if (doors[j].equals("Locked")) {
							doors[j] = "Unlocked";
						}
						else {
							doors[j] = "Locked";
						}
					}
				}

				int openDoors = 0;

				for (int i = 0; i < doors.length; i++) {
					if (!doors[i].equals("Locked")) {
						openDoors++;
					}
				}

				System.out.println(openDoors);
			}
		}
	}
}