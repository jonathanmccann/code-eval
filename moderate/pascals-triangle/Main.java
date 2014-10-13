import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			int depth = Integer.valueOf(line);

			List<Integer> pascalsTriangle = new ArrayList<Integer>();

			StringBuilder sb = new StringBuilder();

			for (int i = 1; i <= depth; i++) {
				for (int j = 1; j <= i; j++) {
					if (j == 1 || j == i) {
						pascalsTriangle.add(1);

						sb.append(1);
					}
					else {
						int leftDigit =
							pascalsTriangle.get(pascalsTriangle.size() - i);
						int rightDigit =
							pascalsTriangle.get(pascalsTriangle.size() - i + 1);

						int currentDigit = leftDigit + rightDigit;

						pascalsTriangle.add(currentDigit);

						sb.append(currentDigit);
					}

					sb.append(" ");
				}
			}

			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}
}