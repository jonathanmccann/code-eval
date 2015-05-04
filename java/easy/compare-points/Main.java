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
			String[] lineArray = line.split("\\s+");

			int o = Integer.valueOf(lineArray[0]);
			int p = Integer.valueOf(lineArray[1]);
			int q = Integer.valueOf(lineArray[2]);
			int r = Integer.valueOf(lineArray[3]);

			if (o == q) {
				if (p == r) {
					System.out.println("here");
				}
				else if (p < r) {
					System.out.println("N");
				}
				else {
					System.out.println("S");
				}

				continue;
			}

			if (p == r) {
				if (o < q) {
					System.out.println("E");
				}
				else {
					System.out.println("W");
				}

				continue;
			}

			if (o < q) {
				if (p < r) {
					System.out.println("NE");
				}
				else {
					System.out.println("SE");
				}
			}
			else if (p < r) {
				System.out.println("NW");
			}
			else {
				System.out.println("SW");
			}
		}
	}
}