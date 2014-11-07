import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				List<Integer> integerList = new ArrayList<Integer>();

				for (int i = 1; i < lineArray.length; i++) {
					integerList.add(Integer.valueOf(lineArray[i]));
				}

				HashSet<Integer> differenceList = new HashSet<Integer>();

				boolean isJollyJumper = true;

				for (int i = 0; i < integerList.size() - 1; i++) {
					int difference = Math.abs(integerList.get(i) - integerList.get(i + 1));

					if (!differenceList.contains(difference) && (difference <= (integerList.size() - 1)) && (difference >= 1)) {
						differenceList.add(difference);
					}
					else {
						isJollyJumper = false;

						break;
					}
				}

				if (isJollyJumper) {
					System.out.println("Jolly");
				}
				else {
					System.out.println("Not jolly");
				}
			}
		}
	}
}