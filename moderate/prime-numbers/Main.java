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
			int n = Integer.valueOf(line);

			StringBuilder sb = new StringBuilder();

			sb.append("2,");

			for (int i = 3; i < n; i += 2) {
				if (isPrime(i)) {
					sb.append(i + ",");
				}
			}

			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}

	private static boolean isPrime(int n) {
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}