import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<String> strings = Arrays.asList(line.split(","));

			List<String> removedDuplicateStrings = new ArrayList<String>();

			if (strings.size() > 0) {
				for (int i = 0; i < strings.size(); i++) {
					if (i == (strings.size() - 1)) {
						removedDuplicateStrings.add(strings.get(i));
					}
					else if (!strings.get(i).equals(strings.get(i + 1))) {
						removedDuplicateStrings.add(strings.get(i));
					}
				}
			}

			StringBuilder sb = new StringBuilder(2 * removedDuplicateStrings.size() - 1);

			for (int i = 0; i < removedDuplicateStrings.size(); i++) {
				String field = removedDuplicateStrings.get(i);

				sb.append(field);

				if ((i + 1) < removedDuplicateStrings.size()) {
					sb.append(",");
				}
			}

			System.out.println(sb.toString());
		}
	}
}