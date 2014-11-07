import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\.");

			if (lineArray.length > 0) {
				StringBuilder sb = new StringBuilder();

				long whole = Long.valueOf(lineArray[0]);

				BigDecimal decimal = BigDecimal.valueOf(Double.valueOf(line));

				// Whole
				sb.append(whole);
				sb.append(".");

				// Minutes
				decimal = decimal.subtract(BigDecimal.valueOf(whole));
				decimal = decimal.multiply(BigDecimal.valueOf(60));
				sb.append(String.format("%02d", decimal.longValue()));
				sb.append("\'");

				// Seconds
				decimal = decimal.subtract(BigDecimal.valueOf(decimal.longValue()));
				decimal = decimal.multiply(BigDecimal.valueOf(60));
				sb.append(String.format("%02d", decimal.longValue()));
				sb.append("\"");

				System.out.println(sb.toString());
			}
		}
	}
}