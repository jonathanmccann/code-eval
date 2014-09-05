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
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				MyStack stack = new MyStack();

				StringBuilder sb = new StringBuilder();

				for (String s : lineArray) {
					stack.push(Integer.parseInt(s));
				}

				while (stack.getSize() > 0) {
					sb.append(stack.pop());

					if (stack.getSize() > 0) {
						sb.append(" ");

						stack.pop();
					}
				}

				System.out.println(sb.toString());
			}
		}
	}

	private static class MyStack {
		List<Integer> integerList = new ArrayList<Integer>();

		public void push(int integer) {
			integerList.add(integer);
		}

		public int pop() {
			int integer = integerList.get(integerList.size() - 1);

			integerList.remove(integerList.size() - 1);

			return integer;
		}

		public int getSize() {
			return integerList.size();
		}
	}
}