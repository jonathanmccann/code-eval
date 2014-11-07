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

			if (lineArray.length > 0) {
				String firstNumber = "";
				String secondNumber = "";
				String operator = "";

				String[] numbers = lineArray[0].split("");
				String[] operation = lineArray[1].split("");

				int index = 0;

				for (int i = 0; i < operation.length; i++) {
					if (operation[i].equals("+") || operation[i].equals("-")) {
						operator = operation[i];
					}
					else if (operator.isEmpty()) {
						firstNumber = firstNumber.concat(numbers[i]);
					}
					else {
						secondNumber = secondNumber.concat(numbers[i - 1]);
					}
				}

				int computedNumber = 0;

				if (operator.equals("+")) {
					computedNumber = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
				}
				else {
					computedNumber = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
				}

				System.out.println(computedNumber);
			}
		}
	}
}