import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String beautifulString = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

			beautifulString = beautifulString.replaceAll("\\s+", "");

			Map<Character, Integer> characterMap = new HashMap<Character, Integer>();

			for (char c : beautifulString.toCharArray()) {
				if (characterMap.containsKey(c)) {
					characterMap.put(c, characterMap.get(c) + 1);
				}
				else {
					characterMap.put(c, 1);
				}
			}

			Map<Character, Integer> sortedCharacterMap = sortCharacterMap(characterMap);

			int sum = 0;
			int counter = 26;

			for (Integer value : sortedCharacterMap.values()) {
				sum += (counter * value);

				counter--;
			}

			System.out.println(sum);
		}
	}

	private static Map sortCharacterMap(Map unsortedMap) {
		List linkedList = new LinkedList(unsortedMap.entrySet());

		Collections.sort(linkedList, new MyComparator());

		Map sortedCharacterMap = new LinkedHashMap();

		for (Iterator it = linkedList.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();

			sortedCharacterMap.put(entry.getKey(), entry.getValue());
		}

		return sortedCharacterMap;
	}

	private static class MyComparator implements Comparator<Object> {
		public int compare(Object firstObject, Object secondObject) {
			return ((Comparable)((Map.Entry)secondObject).getValue()).compareTo(((Map.Entry)firstObject).getValue());
		}
	}
}