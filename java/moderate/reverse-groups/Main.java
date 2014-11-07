import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				int sublistLength = Integer.valueOf(lineArray[1]);

				List<String> digits = new ArrayList<String>(Arrays.asList(lineArray[0].split(",")));

				StringBuilder sb = new StringBuilder(digits.size());

				for (int i = 0; i < digits.size(); i += sublistLength) {
					int end = i + sublistLength;

					List<String> temporaryList = new ArrayList<String>();

					if (end <= digits.size()) {
						temporaryList = digits.subList(i, end);

						Collections.reverse(temporaryList);
					}
					else {
						temporaryList = digits.subList(i, digits.size());
					}

					for (String s : temporaryList) {
						sb.append(s + ",");
					}
				}

				sb.setLength(sb.length() - 1);

				System.out.println(sb.toString());
			}
		}
	}
}