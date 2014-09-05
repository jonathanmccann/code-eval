import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				int a = Integer.valueOf(lineArray[0]);
				long n = Long.valueOf(lineArray[1]);

				Map<Integer, Long> resultsMap = new HashMap<Integer, Long>();

				for (int i = 0; i < 10; i++) {
					resultsMap.put(i, 0L);
				}

				List<Double> cycle = findCycle(a);

				long result = n;

				while ((result % cycle.size()) != 0) {
					result--;
				}

				long delta = n - result;
				long occurrence = result / cycle.size();

				for (int i = 0; i < cycle.size(); i++) {
					resultsMap.put(cycle.get(i).intValue(), occurrence);
				}

				for (int i = 0; i < delta; i++) {
					while (i > cycle.size()) {
						i = i - cycle.size();
					}

					resultsMap.put(cycle.get(i).intValue(), resultsMap.get(cycle.get(i).intValue()) + 1);
				}

				StringBuilder sb = new StringBuilder(19);

				for (int k = 0; k < 10; k++) {
					long value = resultsMap.get(k);

					sb.append(k + ": " + value);

					if ((k + 1) < 10) {
						sb.append(", ");
					}
				}

				System.out.println(sb.toString());
			}
		}
	}

	private static List<Double> findCycle(int a) {
		List<Double> visitedNumbers = new ArrayList<Double>();

		int count = 0;
		double power = 1;

		while (true) {
			power = a * power;

			double lastDigit = power % 10;

			if (visitedNumbers.contains(lastDigit)) {
				return visitedNumbers;
			}
			else {
				visitedNumbers.add(lastDigit);

				count++;
			}
		}
	}
}