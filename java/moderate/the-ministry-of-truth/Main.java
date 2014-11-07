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
			String[] lineArray = line.split(";");

			if (lineArray.length == 2) {
				String[] utterances = lineArray[0].split("\\s+");
				String[] approvedPhrase = lineArray[1].split("\\s+");

				int count = 0;

				StringBuilder sb = new StringBuilder();

				for (String utterance : utterances) {
					int pos = -1;

					if (count < approvedPhrase.length) {
						pos = utterance.indexOf(approvedPhrase[count]);
					}

					if (pos != -1) {
						int utteranceLength = utterance.length();

						for (int i = 0; i < pos; i++) {
							sb.append("_");
						}

						sb.append(approvedPhrase[count]);

						for (int i = (pos + approvedPhrase[count].length()); i < utteranceLength; i++) {
							sb.append("_");
						}

						count++;
					}
					else {
						for (int i = 0; i < utterance.length(); i++) {
							sb.append("_");
						}
					}

					sb.append(" ");
				}

				if (count == approvedPhrase.length) {
					sb.setLength(sb.length() - 1);

					System.out.println(sb.toString());
				}
				else {
					System.out.println("I cannot fix history");
				}
			}
		}
	}
}