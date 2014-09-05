import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			List<MyDouble> doubleList = new ArrayList<MyDouble>();

			if (lineArray.length > 0) {
				StringBuilder sb = new StringBuilder(lineArray.length);

				for (int i = 0; i < lineArray.length; i++) {
					doubleList.add(new MyDouble(lineArray[i]));
				}

				Collections.sort(doubleList);

				for (int i = 0; i < doubleList.size(); i++) {
					sb.append(doubleList.get(i));

					if (i != (doubleList.size() - 1)) {
						sb.append(" ");
					}
				}

				System.out.println(sb.toString());
			}
		}
	}

	static class MyDouble implements Comparable<MyDouble> {
		final double value;
		final String string;

		MyDouble(String str) {
			string = str;
			value = Double.parseDouble(str);
		}

		@Override
		public String toString() {
			return string;
		}

		@Override
		public int compareTo(MyDouble myDouble) {
			return (int) (value - myDouble.value);
		}
	}
}