import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				Set<String> integerSet = new HashSet<String>();

				for (String integer : lineArray[1].split(",")) {
					if (integerSet.contains(integer)) {
						System.out.println(integer);

						break;
					}

					integerSet.add(integer);
				}
			}
		}
	}
}