import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			int quotient = Integer.valueOf(line);

			StringBuilder sb = new StringBuilder();

			while ((quotient != 0) && (quotient != 1)) {
				sb.append(quotient % 2);

				quotient = quotient / 2;
			}
			
			sb.append(quotient);

			System.out.println(sb.reverse());
		}
	}
}