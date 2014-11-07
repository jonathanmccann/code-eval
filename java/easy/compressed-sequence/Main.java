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
			String[] lineArray = line.split("\\s+");

			List<Integer> compressedSequence = new ArrayList<Integer>();

			if (lineArray.length > 0) {
				int previousInteger = Integer.valueOf(lineArray[0]);
				int count = 0;

				for (int i = 1; i <= lineArray.length; i++) {
					if (i == lineArray.length) {
						compressedSequence.add(count + 1);
						compressedSequence.add(previousInteger);

						break;
					}
					else if (Integer.valueOf(lineArray[i]) == previousInteger) {
						count++;
					}
					else {
						compressedSequence.add(count + 1);
						compressedSequence.add(previousInteger);

						count = 0;
						previousInteger = Integer.valueOf(lineArray[i]);
					}
				}
			}

			StringBuilder sb = new StringBuilder(compressedSequence.size() * 2);

			for (int i = 0; i < compressedSequence.size(); i++) {
				sb.append(compressedSequence.get(i));

				if ((i + 1) < compressedSequence.size()) {
					sb.append(" ");
				}
			}

			System.out.println(sb.toString());
		}
	}
}