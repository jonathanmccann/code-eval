import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(",");

			if (lineArray.length > 0) {
				Map<String, String> wordChainMap =
					new HashMap<String, String>();

				for (String word : lineArray) {
					wordChainMap.put(word, word.substring(0, 1));
				}

				int count = 0;

				int wordChainLength = 0;

				for (String startingWord : lineArray) {
					int wordChainSize = findChain(
						startingWord, wordChainMap, new ArrayList<String>(),
						count);

					if (wordChainSize > wordChainLength) {
						if (wordChainSize == 1) {
							wordChainSize++;
						}

						wordChainLength = wordChainSize;

						if (wordChainLength == wordChainMap.size()) {
							break;
						}
					}
				}

				if (wordChainLength > 0) {
					System.out.println(wordChainLength);
				}
				else {
					System.out.println("None");
				}
			}
		}
	}

	private static int findChain(
		String startingWord, Map<String, String> wordChainMap,
		List<String> visitedWords, int count) {

		visitedWords.add(startingWord);

		if (visitedWords.size() == wordChainMap.size()) {
			return visitedWords.size();
		}
		else {
			Iterator iterator = wordChainMap.entrySet().iterator();

			while (iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry)iterator.next();

				if (!visitedWords.contains(mapEntry.getKey()) &&
						!startingWord.equals(mapEntry.getKey()) &&
						startingWord.endsWith((String) mapEntry.getValue())) {

					int intermediateCount = findChain(
						(String) mapEntry.getKey(), wordChainMap,
						new ArrayList<String>(visitedWords), (count + 1));

					if (intermediateCount > count) {
						count = intermediateCount;
					}
				}
			}

			return count;
		}
	}
}