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

			String output = "";

			if (lineArray.length > 0) {
				for (int i = 0; i < lineArray.length - 1; i+=2) {
					String flag = lineArray[i];
					String sequence = lineArray[i + 1];

					if (flag.equals("0")) {
						output = output.concat(sequence);
					}
					else {
						output = output.concat(sequence.replaceAll("0", "1"));
					}
				}
			}

			System.out.println(Long.parseLong(output, 2));
		}
	}
}