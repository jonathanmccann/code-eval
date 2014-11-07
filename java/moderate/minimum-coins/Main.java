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
			int total = Integer.valueOf(line);

			int coinCount = 0;

			while (total > 0) {
				if (total - 5 >= 0) {
					coinCount++;

					total -= 5;
				}
				else if (total - 3 >= 0) {
					coinCount++;

					total -= 3;
				}
				else if (total - 1 >= 0) {
					coinCount++;

					total -= 1;
				}
			}

			System.out.println(coinCount);
		}
	}
}