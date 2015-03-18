import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		Stack<String> stack = new Stack<>();

		while ((line = in.readLine()) != null) {
			line = line.replace(" ", "");

			for (int i = (line.length() - 1); i >= 0; i--) {
				Character symbol = line.charAt(i);

				if (Character.isDigit(symbol)) {
					stack.push(symbol.toString());
				}
				else {
					double firstOperand = Double.valueOf(stack.pop());

					double secondOperand = Double.valueOf(stack.pop());

					double result = 0;

					if (symbol == '+') {
						result = firstOperand + secondOperand;
					}
					else if (symbol == '*') {
						result = firstOperand * secondOperand;
					}
					else {
						result = firstOperand / secondOperand;
					}

					stack.push(Double.toString(result));
				}
			}

			System.out.println(Double.valueOf(stack.pop()).intValue());
		}
	}
}