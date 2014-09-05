import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			List<String> lineList = Arrays.asList(lineArray);

			if (lineArray.length > 0) {
				int colonIndex = lineList.indexOf(":");

				for (int i = colonIndex + 1; i < lineList.size(); i++) {
					String swap = lineList.get(i);

					swap = swap.replace(",", "");

					String[] swapNumbers = swap.split("-");

					Collections.swap(lineList, Integer.valueOf(swapNumbers[0]), Integer.valueOf(swapNumbers[1]));
				}

				StringBuilder sb = new StringBuilder(colonIndex * 2);

				for (int i = 0; i < colonIndex; i++) {
					sb.append(lineList.get(i));

					if ((i + 1) < colonIndex) {
						sb.append(" ");
					}
				}

				System.out.println(sb.toString());
			}
		}
	}
}