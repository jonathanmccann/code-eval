import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		List<String> input = new ArrayList<String>();

		while ((line = in.readLine()) != null) {
			input.add(line);
		}

		int longestLines = Integer.valueOf(input.get(0));

		input.remove(0);

		Collections.sort(input, new StringLengthComparator());

		for (int i = 0; i < longestLines; i++) {
			System.out.println(input.get(i));
		}
	}

	private static class StringLengthComparator implements Comparator<String> {
		public int compare(String firstString, String secondString) {
			return secondString.length() - firstString.length();
		}
	}
}