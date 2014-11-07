import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		long sumTotal = 0;

		while ((line = in.readLine()) != null) {
			sumTotal += Integer.valueOf(line);
		}

		System.out.println(sumTotal);
	}
}