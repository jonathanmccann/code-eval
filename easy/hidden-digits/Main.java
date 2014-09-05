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
			StringBuilder sb = new StringBuilder();

			for (Character c : line.toCharArray()) {
				if ((c >= _characterLowerBound) && (c <= _characterUpperBound)) {
					sb.append(c - _characterLowerBound);
				}
				else if ((c >= _digitLowerBound) && (c <= _digitUpperBound)) {
					sb.append(c);
				}
			}

			if (sb.length() != 0) {
				System.out.println(sb.toString());
			}
			else {
				System.out.println("NONE");
			}
		}
	}

	private static final int _digitLowerBound = 48;
	private static final int _digitUpperBound = 57;
	private static final int _characterLowerBound = 97;
	private static final int _characterUpperBound = 106;

}