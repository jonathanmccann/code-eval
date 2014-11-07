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
			String[] lineArray = line.split(";");

			String[] sentence = lineArray[0].split("\\s+");
			String[] key = lineArray[1].split("\\s+");

			List<Integer> integerKey = new ArrayList<Integer>();

			for (String codeKey : key) {
				integerKey.add(Integer.valueOf(codeKey));
			}

			int sentenceLength = integerKey.size() + 1;
			int missingNumber = findMissingNumber(integerKey, sentenceLength - 1);
			int counter = 0;

			String[] sentenceArray = new String[sentenceLength];

			if (sentence.length > 0) {
				for (int i : integerKey) {
					sentenceArray[i - 1] = sentence[counter];

					counter++;
				}

				sentenceArray[missingNumber - 1] = sentence[counter];
			}

			StringBuilder sb = new StringBuilder(sentenceLength * 2);

			for (int i = 0; i < sentenceLength; i++) {
				sb.append(sentenceArray[i]);

				if (i != (sentenceLength - 1)) {
					sb.append(" ");
				}
			}

			System.out.println(sb.toString());
		}
	}

	private static int findMissingNumber(List<Integer> integerKey, int length) {
		int sum  = (length + 1) * (length + 2) / 2;

		for (int i = 0; i < length; i++) {
		   sum -= integerKey.get(i);
		}

		return sum;
	}
}