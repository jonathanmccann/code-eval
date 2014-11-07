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
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				int x1 = Integer.valueOf(lineArray[0]);
				int x2 = Integer.valueOf(lineArray[2]);
				int x3 = Integer.valueOf(lineArray[4]);
				int x4 = Integer.valueOf(lineArray[6]);
				int y1 = Integer.valueOf(lineArray[1]);
				int y2 = Integer.valueOf(lineArray[3]);
				int y3 = Integer.valueOf(lineArray[5]);
				int y4 = Integer.valueOf(lineArray[7]);

				if (x3 > x2 || x4 < x1 || y3 < y2 || y4 > y1) {
					System.out.println("False");
				}
				else {
					System.out.println("True");
				}
			}
		}
	}
}