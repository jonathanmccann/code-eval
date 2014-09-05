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
            String[] lineArray = line.split(",");

        	if (lineArray.length > 0) {
				int comparingNumber = Integer.valueOf(lineArray[0]);
				int multipleNumber = Integer.valueOf(lineArray[1]);

				int increasingMultipleNumber = multipleNumber;

				while (increasingMultipleNumber < comparingNumber) {
					increasingMultipleNumber = increasingMultipleNumber + multipleNumber;
				}

				System.out.println(increasingMultipleNumber);
			}
        }
    }
}