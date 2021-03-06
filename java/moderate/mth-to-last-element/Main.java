import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				int position = Integer.valueOf(lineArray[lineArray.length - 1]);

				if (position <= (lineArray.length - 1)) {
					List<String> list = Arrays.asList(lineArray);

					Collections.reverse(list);

					System.out.println(list.get(position));
				}
			}
		}
	}
}