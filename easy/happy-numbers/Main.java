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
			List<Integer> visitedNumbers = new ArrayList<Integer>();

			boolean isHappyNumber = isHappyNumber(Integer.valueOf(line), visitedNumbers);

			if (isHappyNumber) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}

	private static boolean isHappyNumber(int happyNumber, List<Integer> visitedNumbers) {
		int sum = 0;

		List<Integer> digits = new ArrayList<Integer>();

		while(happyNumber > 0) {
			digits.add(happyNumber % 10);
			happyNumber /= 10;
		}

		for (int i : digits) {
			sum += Math.pow(i, 2);
		}

		if (sum == 1) {
			return true;
		}
		else if (visitedNumbers.contains(sum)) {
			return false;
		}
		else {
			visitedNumbers.add(sum);

			return isHappyNumber(sum, visitedNumbers);
		}
	}
}