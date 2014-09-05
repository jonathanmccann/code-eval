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
			String[] lineArray = line.split("\\|");

			if (lineArray.length == 2) {
				String[] firstList = lineArray[0].trim().split("\\s+");
				String[] secondList = lineArray[1].trim().split("\\s+");

				StringBuilder sb = new StringBuilder(firstList.length);

				for (int i = 0; i < firstList.length; i++) {
					int product = Integer.parseInt(firstList[i]) * Integer.parseInt(secondList[i]);

					sb.append(product + " ");
				}

				System.out.println(sb.toString());
			}
			else {
				System.out.println("Invalid input");
			}
		}
	}
}