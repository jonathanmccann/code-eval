import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;
		
		int slangCounter = 0;

		boolean isReplacePunctuation = false;
		
		while ((line = in.readLine()) != null) {
			Matcher matcher = _punctuationPattern.matcher(line);

			int index = 0;

			while (matcher.find()) {
				if (isReplacePunctuation) {
					System.out.print(
						line.substring(index, matcher.start()) +
							_slangMap.get(slangCounter));

					slangCounter++;

					if (slangCounter == 8) {
						slangCounter = 0;
					}
				}
				else {
					System.out.print(
						line.substring(index, matcher.start()) +
							matcher.group());
				}

				isReplacePunctuation = !isReplacePunctuation;

				index = matcher.start() + 1;
			}

			System.out.println();
		}
	}

	private static Map<Integer, String> _slangMap;

	private static Pattern _punctuationPattern = Pattern.compile("\\.|!|\\?");

	static {
		Map<Integer, String> staticMap = new HashMap<Integer, String>();

		staticMap.put(0, ", yeah!");
		staticMap.put(1, ", this is crazy, I tell ya.");
		staticMap.put(2, ", can U believe this?");
		staticMap.put(3, ", eh?");
		staticMap.put(4, ", aw yea.");
		staticMap.put(5, ", yo.");
		staticMap.put(6, "? No way!");
		staticMap.put(7, ". Awesome!");

		_slangMap = staticMap;
	}
}