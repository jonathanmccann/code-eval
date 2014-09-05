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

				StringBuilder sb = new StringBuilder(lineArray.length / 2);

				for (String s : lineArray) {
					stack.push(Integer.parseInt(s));
				}

				for (int i = 0; i < lineArray.length / 2; i++) {
					sb.append(stack.pop());

					if (i != (lineArray.length - 1)) {
						sb.append(" ");
					}

					if (stack.getSize() > 0) {
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